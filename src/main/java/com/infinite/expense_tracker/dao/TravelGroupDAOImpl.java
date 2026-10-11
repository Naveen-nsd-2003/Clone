package com.infinite.expense_tracker.dao;

import com.infinite.expense_tracker.model.TravelGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TravelGroupDAOImpl implements TravelGroupDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addGroup(TravelGroup group) {

        String sql = "INSERT INTO TravelGroup (createdBy, groupName, startDate, endDate, initialAmount) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                group.getCreatedBy(),
                group.getGroupName(),
                group.getStartDate(),
                group.getEndDate(),
                group.getInitialAmount());
    }

    @Override
    public List<TravelGroup> getAllGroups() {

        String sql = "SELECT * FROM TravelGroup";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            TravelGroup g = new TravelGroup();
            g.setGroupId(rs.getInt("groupId"));
            g.setCreatedBy(rs.getInt("createdBy"));
            g.setGroupName(rs.getString("groupName"));
            g.setStartDate(rs.getDate("startDate"));
            g.setEndDate(rs.getDate("endDate"));
            g.setInitialAmount(rs.getDouble("initialAmount"));
            return g;
        });
    }

    @Override
    public void deleteGroup(int groupId) {

        String sql = "DELETE FROM TravelGroup WHERE groupId=?";

        jdbcTemplate.update(sql, groupId);
    }

    @Override
    public TravelGroup getGroupById(int groupId) {

        String sql = "SELECT * FROM TravelGroup WHERE groupId=?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            TravelGroup g = new TravelGroup();
            g.setGroupId(rs.getInt("groupId"));
            g.setCreatedBy(rs.getInt("createdBy"));
            g.setGroupName(rs.getString("groupName"));
            g.setStartDate(rs.getDate("startDate"));
            g.setEndDate(rs.getDate("endDate"));
            g.setInitialAmount(rs.getDouble("initialAmount"));
            return g;
        }, groupId);
    }

    @Override
    public void updateGroup(TravelGroup group) {

        String sql = "UPDATE TravelGroup SET createdBy=?, groupName=?, startDate=?, endDate=?, initialAmount=? WHERE groupId=?";

        jdbcTemplate.update(sql,
                group.getCreatedBy(),
                group.getGroupName(),
                group.getStartDate(),
                group.getEndDate(),
                group.getInitialAmount(),
                group.getGroupId());
    }
}