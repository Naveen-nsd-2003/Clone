package com.infinite.expense_tracker.dao;

import com.infinite.expense_tracker.model.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupMemberDAOImpl implements GroupMemberDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMember(GroupMember member) {

        String sql = "INSERT INTO GroupMembers (groupId, userId, amountCollected) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql,
                member.getGroupId(),
                member.getUserId(),
                member.getAmountCollected());
    }

    @Override
    public List<GroupMember> getAllMembers() {

        String sql = "SELECT * FROM GroupMembers";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            GroupMember gm = new GroupMember();
            gm.setGmId(rs.getInt("gmId"));
            gm.setGroupId(rs.getInt("groupId"));
            gm.setUserId(rs.getInt("userId"));
            gm.setAmountCollected(rs.getDouble("amountCollected"));
            return gm;
        });
    }

    @Override
    public void deleteMember(int gmId) {

        String sql = "DELETE FROM GroupMembers WHERE gmId=?";

        jdbcTemplate.update(sql, gmId);
    }

    @Override
    public GroupMember getMemberById(int gmId) {

        String sql = "SELECT * FROM GroupMembers WHERE gmId=?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            GroupMember gm = new GroupMember();
            gm.setGmId(rs.getInt("gmId"));
            gm.setGroupId(rs.getInt("groupId"));
            gm.setUserId(rs.getInt("userId"));
            gm.setAmountCollected(rs.getDouble("amountCollected"));
            return gm;
        }, gmId);
    }

    @Override
    public void updateMember(GroupMember member) {

        String sql = "UPDATE GroupMembers SET groupId=?, userId=?, amountCollected=? WHERE gmId=?";

        jdbcTemplate.update(sql,
                member.getGroupId(),
                member.getUserId(),
                member.getAmountCollected(),
                member.getGmId());
    }
}