package com.app.splitwise.Service;

import com.app.splitwise.Model.UserRequest;
import com.app.splitwise.entity.User;
import com.app.splitwise.manager.UserManager;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserManager userManager;
    @Autowired
    BalanceSheetService balanceSheetService;

    public void addUser(UserRequest user) {
        if(user.getId() == null || user.getName() == null || user.getName().equals("")){
            throw new RuntimeException("400, userId or name cannot be null");
        }
        User user1 = new User(user.getId(), user.getName());
        userManager.save(balanceSheetService.createBalanceSheet(user1));
    }

    public void addFriends(Integer userId, List<User> users) {
        User user = userManager.getUser(userId);
        if(Objects.equals(user, null)) {
            throw new RuntimeException("400, User does not exist with id : " + userId);
        }
        userManager.addFriends(userId, users);
    }

    public List<User> getAllUsersById(List<Integer> ids) {
        return userManager.getAllUsersById(ids);
    }


}
