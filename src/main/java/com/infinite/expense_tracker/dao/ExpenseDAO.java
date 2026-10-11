package com.infinite.expense_tracker.dao;

import com.infinite.expense_tracker.model.Expense;
import java.util.List;

public interface ExpenseDAO {

    void addExpense(Expense expense);

    List<Expense> getAllExpenses();

    void deleteExpense(int expId);

    Expense getExpenseById(int expId);

    void updateExpense(Expense expense);
}