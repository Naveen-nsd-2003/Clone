package com.infinite.expense_tracker.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupMember {

    private int gmId;
    private int groupId;
    private int userId;
    private double amountCollected;
}