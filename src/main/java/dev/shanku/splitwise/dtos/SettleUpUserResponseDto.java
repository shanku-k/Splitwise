package dev.shanku.splitwise.dtos;

import dev.shanku.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
private List<Expense> expenses;   //these will be dummy expenses
}
