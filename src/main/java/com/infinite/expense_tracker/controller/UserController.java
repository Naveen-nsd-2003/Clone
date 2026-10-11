package com.infinite.expense_tracker.controller;

import com.infinite.expense_tracker.dao.UserDAO;
import com.infinite.expense_tracker.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;


    @GetMapping("/")
    public String home() {
        return "index";   // index.jsp
    }


    @GetMapping("/viewUsers")
    public String viewUsers(Model model) {

        List<User> userList = userDao.getAllUsers();

        model.addAttribute("userList", userList);

        return "userList";
    }


    @GetMapping("/addUser")
    public String addUserPage() {
        return "userForm";
    }


    @GetMapping("/saveUser")
    public String saveUser(HttpServletRequest request) {

        User user = new User();

        user.setUserName(request.getParameter("userName"));
        user.setEmail(request.getParameter("email"));

        userDao.addUser(user);

        return "redirect:/viewUsers";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request) {

        int userId = Integer.parseInt(request.getParameter("userId"));

        userDao.deleteUser(userId);

        return "redirect:/viewUsers";
    }


    @GetMapping("/updateUserPage")
    public String updateUserPage(Model model, HttpServletRequest request) {

        int userId = Integer.parseInt(request.getParameter("userId"));

        User user = userDao.getUserById(userId);

        model.addAttribute("user", user);

        return "userEditForm";   // userUpdate.jsp
    }


    @GetMapping("/updateUser")
    public String updateUser(HttpServletRequest request) {

        User user = new User();

        user.setUserId(Integer.parseInt(request.getParameter("userId")));
        user.setUserName(request.getParameter("userName"));
        user.setEmail(request.getParameter("email"));

        userDao.updateUser(user);

        return "redirect:/viewUsers";
    }
}