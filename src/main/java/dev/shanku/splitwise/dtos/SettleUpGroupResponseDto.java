package dev.shanku.splitwise.dtos;

import dev.shanku.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Expense> expenses;  //this will be dummy expenses
}
