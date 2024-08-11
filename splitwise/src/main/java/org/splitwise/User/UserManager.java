package org.splitwise.User;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserManager {
    private List<User> userList;

    public UserManager(){
        this.userList = new ArrayList<>();
    }
    public void addUser(User user){
        userList.add(user);
    }
    public void addUser(List<User> users){
        userList.addAll(users);
    }

    public void addFriends(User user, List<User> friends){
        for(User u: userList){
            if(u.getUserId().equals(user.getUserId())){
                u.getFriends().addAll(friends);
            }
        }
    }
}
