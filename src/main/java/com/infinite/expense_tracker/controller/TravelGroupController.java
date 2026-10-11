package com.infinite.expense_tracker.controller;

import com.infinite.expense_tracker.dao.TravelGroupDAO;
import com.infinite.expense_tracker.model.TravelGroup;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.List;

@Controller
public class TravelGroupController {

    @Autowired
    private TravelGroupDAO groupDao;


    @GetMapping("/viewGroups")
    public String viewGroups(Model model) {

        List<TravelGroup> groupList = groupDao.getAllGroups();

        model.addAttribute("groupList", groupList);

        return "groupList";
    }

    @GetMapping("/groupForm")
    public String groupForm() {
        return "groupForm";
    }


    @GetMapping("/saveGroup")
    public String saveGroup(HttpServletRequest request) {

        TravelGroup g = new TravelGroup();

        g.setCreatedBy(Integer.parseInt(request.getParameter("createdBy")));
        g.setGroupName(request.getParameter("groupName"));
        g.setStartDate(Date.valueOf(request.getParameter("startDate")));
        g.setEndDate(Date.valueOf(request.getParameter("endDate")));
        g.setInitialAmount(Double.parseDouble(request.getParameter("initialAmount")));

        groupDao.addGroup(g);

        return "redirect:/viewGroups";
    }


    @GetMapping("/deleteGroup")
    public String deleteGroup(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("groupId"));

        groupDao.deleteGroup(id);

        return "redirect:/viewGroups";
    }


    @GetMapping("/updateGroupPage")
    public String updateGroupPage(Model model, HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("groupId"));

        TravelGroup g = groupDao.getGroupById(id);

        model.addAttribute("group", g);

        return "groupUpdate";
    }


    @GetMapping("/updateGroup")
    public String updateGroup(HttpServletRequest request) {

        TravelGroup g = new TravelGroup();

        g.setGroupId(Integer.parseInt(request.getParameter("groupId")));
        g.setCreatedBy(Integer.parseInt(request.getParameter("createdBy")));
        g.setGroupName(request.getParameter("groupName"));
        g.setStartDate(Date.valueOf(request.getParameter("startDate")));
        g.setEndDate(Date.valueOf(request.getParameter("endDate")));
        g.setInitialAmount(Double.parseDouble(request.getParameter("initialAmount")));

        groupDao.updateGroup(g);

        return "redirect:/viewGroups";
    }
}