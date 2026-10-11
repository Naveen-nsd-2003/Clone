package com.infinite.expense_tracker.dao;

import com.infinite.expense_tracker.model.TravelGroup;
import java.util.List;

public interface TravelGroupDAO {

    void addGroup(TravelGroup group);

    List<TravelGroup> getAllGroups();

    void deleteGroup(int groupId);

    TravelGroup getGroupById(int groupId);

    void updateGroup(TravelGroup group);
}