package dev.shanku.splitwise.repositories;

import dev.shanku.splitwise.models.ExpenseUser;
import dev.shanku.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {

    List<ExpenseUser> findByUser(User user);
}

