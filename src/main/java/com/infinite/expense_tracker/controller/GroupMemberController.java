

package com.infinite.expense_tracker.controller;

import com.infinite.expense_tracker.dao.GroupMemberDAO;
import com.infinite.expense_tracker.dao.TravelGroupDAO;
import com.infinite.expense_tracker.dao.UserDAO;
import com.infinite.expense_tracker.model.GroupMember;
import com.infinite.expense_tracker.model.TravelGroup;
import com.infinite.expense_tracker.model.User;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GroupMemberController {

    @Autowired
    private GroupMemberDAO memberDao;


    @Autowired
    private TravelGroupDAO groupDao;

    @Autowired
    private UserDAO userDao;


 /*   @GetMapping("/viewMembers")
    public String viewMembers(Model model) {

        List<GroupMember> list = memberDao.getAllMembers();
        model.addAttribute("memberList", list);

        return "memberList";
    }
*/
 @GetMapping("/viewMembers")
 public String viewMembers(Model model) {


     List<GroupMember> members = memberDao.getAllMembers();


     List<User> users = userDao.getAllUsers();


     List<TravelGroup> groups = groupDao.getAllGroups();


     Map<Integer, String> userMap = new HashMap<>();
     for (User u : users) {
         userMap.put(u.getUserId(), u.getUserName());
     }

     Map<Integer, String> groupMap = new HashMap<>();
     for (TravelGroup g : groups) {
         groupMap.put(g.getGroupId(), g.getGroupName());
     }


     model.addAttribute("memberList", members);
     model.addAttribute("userMap", userMap);
     model.addAttribute("groupMap", groupMap);

     return "memberList";
 }

    @GetMapping("/memberForm")
    public String memberForm(Model model) {

        // ✅ SEND DATA FOR DROPDOWN
        List<TravelGroup> groups = groupDao.getAllGroups();
        List<User> users = userDao.getAllUsers();

        model.addAttribute("groups", groups);
        model.addAttribute("users", users);

        return "memberForm";
    }


    @GetMapping("/saveMember")
    public String saveMember(HttpServletRequest request) {

        GroupMember gm = new GroupMember();

        gm.setGroupId(Integer.parseInt(request.getParameter("groupId")));
        gm.setUserId(Integer.parseInt(request.getParameter("userId")));
        gm.setAmountCollected(Double.parseDouble(request.getParameter("amountCollected")));

        memberDao.addMember(gm);

        return "redirect:/viewMembers";
    }


    @GetMapping("/deleteMember")
    public String deleteMember(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("gmId"));

        memberDao.deleteMember(id);

        return "redirect:/viewMembers";
    }


    @GetMapping("/updateMemberPage")
    public String updateMemberPage(Model model, HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("gmId"));

        GroupMember gm = memberDao.getMemberById(id);


        List<TravelGroup> groups = groupDao.getAllGroups();
        List<User> users = userDao.getAllUsers();

        model.addAttribute("member", gm);
        model.addAttribute("groups", groups);
        model.addAttribute("users", users);

        return "memberUpdate";
    }


    @GetMapping("/updateMember")
    public String updateMember(HttpServletRequest request) {

        GroupMember gm = new GroupMember();

        gm.setGmId(Integer.parseInt(request.getParameter("gmId")));
        gm.setGroupId(Integer.parseInt(request.getParameter("groupId")));
        gm.setUserId(Integer.parseInt(request.getParameter("userId")));
        gm.setAmountCollected(Double.parseDouble(request.getParameter("amountCollected")));

        memberDao.updateMember(gm);

        return "redirect:/viewMembers";
    }
}
