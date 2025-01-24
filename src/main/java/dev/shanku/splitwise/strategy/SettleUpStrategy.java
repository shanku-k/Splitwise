package dev.shanku.splitwise.strategy;

import dev.shanku.splitwise.models.Expense;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
