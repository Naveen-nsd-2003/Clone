package com.infinite.expense_tracker.dao;

import com.infinite.expense_tracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {

        String sql = "INSERT INTO users (userName, email) VALUES (?, ?)";

        jdbcTemplate.update(sql,
                user.getUserName(),
                user.getEmail());
    }

    @Override
    public List<User> getAllUsers() {

        String sql = "SELECT * FROM users";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User u = new User();
            u.setUserId(rs.getInt("userId"));
            u.setUserName(rs.getString("userName"));
            u.setEmail(rs.getString("email"));
            return u;
        });
    }

    @Override
    public void deleteUser(int userId) {

        String sql = "DELETE FROM users WHERE userId=?";

        jdbcTemplate.update(sql, userId);
    }

    @Override
    public User getUserById(int userId) {

        String sql = "SELECT * FROM users WHERE userId=?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            User u = new User();
            u.setUserId(rs.getInt("userId"));
            u.setUserName(rs.getString("userName"));
            u.setEmail(rs.getString("email"));
            return u;
        }, userId);
    }

    @Override
    public void updateUser(User user) {

        String sql = "UPDATE users SET userName=?, email=? WHERE userId=?";

        jdbcTemplate.update(sql,
                user.getUserName(),
                user.getEmail(),
                user.getUserId());
    }
}