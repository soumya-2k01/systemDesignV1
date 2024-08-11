package org.splitwise;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.splitwise.User.GroupManager;
import org.splitwise.User.User;
import org.splitwise.User.UserManager;

@Getter
public class Splitwise {
    private UserManager userManager;
    private GroupManager groupManager;

    public Splitwise(){
        this.userManager = new UserManager();
        this.groupManager = new GroupManager();
    }

    public void setUp(){
        userManager.addUser(getUserList1());
    }

    public void scenario1(){

    }

    public List<User> getUserList1(){
        List<User> users = new ArrayList<>();
        for(int i=0; i<5; i++){
            User user = new User(i+1,"SG"+(i+1), new ArrayList<>(), new BalanceSheet());
            users.add(user);
        }
        return users;
    }
}
