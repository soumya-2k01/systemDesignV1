package com.app.splitwise.Service;

import com.app.splitwise.entity.Group;
import com.app.splitwise.entity.User;
import com.app.splitwise.manager.GroupManager;
import com.app.splitwise.manager.UserManager;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    GroupManager groupManager;
    @Autowired
    UserManager userManager;

    public void createGroup(Integer userId, Group group) {
        if(userManager.getUser(userId) == null) {
            throw new RuntimeException("400, User does not exist with id : " + userId);
        }
        groupManager.createGroup(group);
        groupManager.addMembers(group, Arrays.asList(userManager.getUser(userId)));
    }

    public void addFriendsToGroup(Integer groupId, List<User> members) {
        Group group = groupManager.getGroup(groupId);
        if(Objects.isNull(group)) {
            throw new RuntimeException("400, Group does not exist with id : " + groupId);
        }
        groupManager.addMembers(group, members);
    }

    public List<User> getFriendsOfGroup(Integer groupId) {
        Group group = groupManager.getGroup(groupId);
        if(Objects.isNull(group)) {
            throw new RuntimeException("400, Group does not exist with id : " + groupId);
        }
        return group.getMembers();
    }

    public Group getGroup(Integer groupId) {
        return groupManager.getGroup(groupId);
    }


}
