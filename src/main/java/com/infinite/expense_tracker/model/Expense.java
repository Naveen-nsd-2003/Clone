package com.infinite.expense_tracker.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Expense {

    private int expId;
    private int groupId;
    private Date expenseDate;
    private String expenseDescription;
    private int paidBy;
    private double amount;
}