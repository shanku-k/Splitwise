package dev.shanku.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="expenses")
public class Expense extends BaseModel{
    private String description;
    private Double amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @ManyToOne
    private User createdBy;  //creator of the expense
    @OneToMany
    private List<ExpenseUser> expenseUsers;
}

/*

Expense---------User  (1user can create many expenses)
M       <-       1

ExpenseUser-------Expense (cardinality between a mapping table & single entity is always M:1)

 */