package com.infinite.expense_tracker.dao;

import com.infinite.expense_tracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseDAOImpl implements ExpenseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addExpense(Expense expense) {

        String sql = "INSERT INTO Expenses (groupId, expenseDate, expenseDescription, paidBy, amount) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                expense.getGroupId(),
                expense.getExpenseDate(),
                expense.getExpenseDescription(),
                expense.getPaidBy(),
                expense.getAmount());
    }

    @Override
    public List<Expense> getAllExpenses() {

        String sql = "SELECT * FROM Expenses";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Expense e = new Expense();
            e.setExpId(rs.getInt("expId"));
            e.setGroupId(rs.getInt("groupId"));
            e.setExpenseDate(rs.getDate("expenseDate"));
            e.setExpenseDescription(rs.getString("expenseDescription"));
            e.setPaidBy(rs.getInt("paidBy"));
            e.setAmount(rs.getDouble("amount"));
            return e;
        });
    }

    @Override
    public void deleteExpense(int expId) {

        String sql = "DELETE FROM Expenses WHERE expId=?";

        jdbcTemplate.update(sql, expId);
    }

    @Override
    public Expense getExpenseById(int expId) {

        String sql = "SELECT * FROM Expenses WHERE expId=?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Expense e = new Expense();
            e.setExpId(rs.getInt("expId"));
            e.setGroupId(rs.getInt("groupId"));
            e.setExpenseDate(rs.getDate("expenseDate"));
            e.setExpenseDescription(rs.getString("expenseDescription"));
            e.setPaidBy(rs.getInt("paidBy"));
            e.setAmount(rs.getDouble("amount"));
            return e;
        }, expId);
    }

    @Override
    public void updateExpense(Expense expense) {

        String sql = "UPDATE Expenses SET groupId=?, expenseDate=?, expenseDescription=?, paidBy=?, amount=? WHERE expId=?";

        jdbcTemplate.update(sql,
                expense.getGroupId(),
                expense.getExpenseDate(),
                expense.getExpenseDescription(),
                expense.getPaidBy(),
                expense.getAmount(),
                expense.getExpId());
    }
}