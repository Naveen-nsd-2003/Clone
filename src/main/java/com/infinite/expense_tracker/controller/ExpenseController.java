package com.infinite.expense_tracker.controller;

import com.infinite.expense_tracker.dao.ExpenseDAO;
import com.infinite.expense_tracker.dao.TravelGroupDAO;
import com.infinite.expense_tracker.dao.UserDAO;
import com.infinite.expense_tracker.model.Expense;
import com.infinite.expense_tracker.model.TravelGroup;
import com.infinite.expense_tracker.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseDAO expenseDao;

    @Autowired
    private TravelGroupDAO groupDao;

    @Autowired
    private UserDAO userDao;

    @GetMapping("/viewExpenses")
    public String viewExpenses(Model model) {

        List<Expense> list = expenseDao.getAllExpenses();

        model.addAttribute("expenseList", list);

        return "expenseList";
    }


    @GetMapping("/expenseForm")
    public String expenseForm(Model model) {

        List<TravelGroup> groups = groupDao.getAllGroups();
        List<User> users = userDao.getAllUsers();

        model.addAttribute("groups", groups);
        model.addAttribute("users", users);

        return "expenseForm";
    }


    @GetMapping("/saveExpense")
    public String saveExpense(HttpServletRequest request) {

        Expense e = new Expense();

        e.setGroupId(Integer.parseInt(request.getParameter("groupId")));
        e.setExpenseDate(Date.valueOf(request.getParameter("expenseDate")));
        e.setExpenseDescription(request.getParameter("expenseDescription"));
        e.setPaidBy(Integer.parseInt(request.getParameter("paidBy")));
        e.setAmount(Double.parseDouble(request.getParameter("amount")));

        expenseDao.addExpense(e);

        return "redirect:/viewExpenses";
    }


    @GetMapping("/deleteExpense")
    public String deleteExpense(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("expId"));

        expenseDao.deleteExpense(id);

        return "redirect:/viewExpenses";
    }


    @GetMapping("/updateExpensePage")
    public String updateExpensePage(Model model, HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("expId"));

        Expense e = expenseDao.getExpenseById(id);

        List<TravelGroup> groups = groupDao.getAllGroups();
        List<User> users = userDao.getAllUsers();

        model.addAttribute("expense", e);
        model.addAttribute("groups", groups);
        model.addAttribute("users", users);

        return "expenseUpdate";
    }


    @GetMapping("/updateExpense")
    public String updateExpense(HttpServletRequest request) {

        Expense e = new Expense();

        e.setExpId(Integer.parseInt(request.getParameter("expId")));
        e.setGroupId(Integer.parseInt(request.getParameter("groupId")));
        e.setExpenseDate(Date.valueOf(request.getParameter("expenseDate")));
        e.setExpenseDescription(request.getParameter("expenseDescription"));
        e.setPaidBy(Integer.parseInt(request.getParameter("paidBy")));
        e.setAmount(Double.parseDouble(request.getParameter("amount")));

        expenseDao.updateExpense(e);

        return "redirect:/viewExpenses";
    }
}