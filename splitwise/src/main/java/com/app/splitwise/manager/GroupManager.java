package com.app.splitwise.manager;

import com.app.splitwise.entity.Group;
import com.app.splitwise.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class GroupManager {
    private List<Group> groups;
    private Map<Integer, Group> groupMap;
    //private Map<Group, User> membersByGroup;

    public GroupManager() {
        this.groups = new ArrayList<>();
        this.groupMap = new HashMap<>();
        //this.membersByGroup = new HashMap<>();
    }

    public String createGroup(Group group) {
        if(groupMap.containsKey(group.getId())) {
            throw new RuntimeException("Group already exists with id: " + group.getId());
        }
        groups.add(group);
        groupMap.put(group.getId(), group);
        return "Group created";
    }

    public void deleteGroup(Group group) {
        if(!groupMap.containsKey(group.getId())) {
            throw new RuntimeException("No group exists with the given id : "+ group.getId());
        }
        groups.remove(group);
        groupMap.remove(group.getId());
    }

    public Group getGroup(Integer groupId) {
        return groupMap.getOrDefault(groupId, null);
    }

    public void addMembers(Group group, List<User> users) {
        if(groupMap.containsKey(group.getId()))
            groupMap.get(group.getId()).getMembers().addAll(users);
    }


}
