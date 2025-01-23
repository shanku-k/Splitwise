package dev.shanku.splitwise.strategy;

import dev.shanku.splitwise.models.Expense;
import org.springframework.context.annotation.Configuration;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //implement this algo by using min & max heap
        return List.of();
    }
}
