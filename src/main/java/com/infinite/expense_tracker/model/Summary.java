package com.infinite.expense_tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Summary {

    private int userId;
    private String userName;

    private double initialAmount;
    private double extraPaid;
    private double totalPaid;

    private double perHead;
    private double balance;
}