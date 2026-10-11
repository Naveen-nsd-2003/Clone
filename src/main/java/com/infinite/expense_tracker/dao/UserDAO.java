package com.infinite.expense_tracker.dao;

import com.infinite.expense_tracker.model.User;
import java.util.List;

public interface UserDAO {

    void addUser(User user);

    List<User> getAllUsers();

    void deleteUser(int userId);

    User getUserById(int userId);

    void updateUser(User user);
}