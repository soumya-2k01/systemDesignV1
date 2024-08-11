package org.splitwise.User;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupManager {
    private List<Group> groupList;

    public GroupManager(){
        this.groupList = new ArrayList<>();
    }
    public void createGroup(Group group){
        groupList.add(group);
    }

    public void addFriendsToGroup(Group group, List<User> friends){
        for(Group g : groupList){
            if(g.getGroupId().equals(group.getGroupId())){
                g.getMembers().addAll(friends);
            }
        }
    }
}
