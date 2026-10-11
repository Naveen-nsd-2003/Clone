package com.infinite.expense_tracker.dao;

import com.infinite.expense_tracker.model.GroupMember;
import java.util.List;

public interface GroupMemberDAO {

    void addMember(GroupMember member);

    List<GroupMember> getAllMembers();

    void deleteMember(int gmId);

    GroupMember getMemberById(int gmId);

    void updateMember(GroupMember member);
}