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
public class TravelGroup {

    private int groupId;
    private int createdBy;
    private String groupName;
    private Date startDate;
    private Date endDate;
    private double initialAmount;
}
