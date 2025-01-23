package dev.shanku.splitwise.services;

import dev.shanku.splitwise.exceptions.UserNotFoundException;
import dev.shanku.splitwise.models.Expense;
import dev.shanku.splitwise.models.ExpenseUser;
import dev.shanku.splitwise.models.User;
import dev.shanku.splitwise.repositories.ExpenseUserRepository;
import dev.shanku.splitwise.repositories.UserRepository;
import dev.shanku.splitwise.strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    //this should be an interface ideally, but we have just single implementation so we are doing it here

    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }


    public List<Expense> settleUpUser(Long userId) {
        //check if user is present in the system
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        //if present, get the user
        User user = optionalUser.get();

        //fetch all the expenses where this user was present(paidBy expenses & hadToPay expenses)
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);

        Set<Expense> expensesToSettle = new HashSet<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            expensesToSettle.add(expenseUser.getExpense());
        }
        //after getting the set of unique expenses of the user, perform the algorithm of settleUp
        //these set of expenses are nothing but the transactions

        List<Expense> transactions= settleUpStrategy.settleUp(expensesToSettle.stream().toList());
        //converted Set<Expense> to List<Expense> and called the settleUpStrategy algorithm


        /*Instead of returning all the transactions, let's return the
        transactions where current user is present
        */
        List<Expense> finalTransactions = new ArrayList<>();
        for(Expense expense : transactions) {
            for(ExpenseUser expenseUser : expense.getExpenseUsers()) {
                if (expenseUser.getUser().equals(user))
                    finalTransactions.add(expense);
            }
        }
        return finalTransactions;
    }



    public List<Expense> settleUpGroup(Long groupId) {
        return null;
    }
}
