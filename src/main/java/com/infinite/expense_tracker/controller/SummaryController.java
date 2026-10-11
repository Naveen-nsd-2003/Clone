
package com.infinite.expense_tracker.controller;

import com.infinite.expense_tracker.dao.*;
import com.infinite.expense_tracker.model.*;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class SummaryController {

    @Autowired
    private GroupMemberDAO memberDao;

    @Autowired
    private ExpenseDAO expenseDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private TravelGroupDAO groupDao;

    @GetMapping("/summary")
    public String showSummary(Model model, HttpServletRequest request) {


        int groupId = Integer.parseInt(request.getParameter("groupId"));


        TravelGroup group = groupDao.getGroupById(groupId);


        List<GroupMember> allMembers = memberDao.getAllMembers();
        List<GroupMember> groupMembers = new ArrayList<>();

        for (GroupMember gm : allMembers) {
            if (gm.getGroupId() == groupId) {
                groupMembers.add(gm);
            }
        }


        double totalInitial = 0;
        for (GroupMember gm : groupMembers) {
            totalInitial += gm.getAmountCollected();
        }

        List<Expense> allExpenses = expenseDao.getAllExpenses();

        double totalSpent = 0; // actual total spending


        Map<Integer, Double> expensePaidMap = new HashMap<>();

        for (Expense e : allExpenses) {

            if (e.getGroupId() == groupId) {

                // Total actual spending
                totalSpent += e.getAmount();

                // Track who paid how much
                expensePaidMap.put(
                        e.getPaidBy(),
                        expensePaidMap.getOrDefault(e.getPaidBy(), 0.0) + e.getAmount()
                );
            }
        }


        int totalMembers = groupMembers.size();
        double perHead = totalSpent / totalMembers;


        List<Summary> summaryList = new ArrayList<>();

        for (GroupMember gm : groupMembers) {

            int userId = gm.getUserId();

            double initialPaid = gm.getAmountCollected();

            double expensePaid = expensePaidMap.getOrDefault(userId, 0.0);

            double totalPaid = initialPaid + expensePaid;

            double balance = totalPaid - perHead;

            User user = userDao.getUserById(userId);

            Summary summary = new Summary(
                    userId,
                    user.getUserName(),
                    initialPaid,
                    expensePaid,
                    totalPaid,
                    perHead,
                    balance
            );

            summaryList.add(summary);
        }


        double remainingAmount = totalSpent- totalInitial ;


        model.addAttribute("group", group);
        model.addAttribute("summaryList", summaryList);

        model.addAttribute("totalInitial", totalInitial);
        model.addAttribute("totalSpent", totalSpent);
        model.addAttribute("perHead", perHead);
        model.addAttribute("remainingAmount", remainingAmount);

        return "summary";
    }
}