package com.app.splitwise.manager;

import com.app.splitwise.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
    private List<User> users;
    private Map<Integer, User> userMap;
    private Map<User, List<User>> friends;

    public UserManager() {
        this.users = new ArrayList<>();
        this.friends = new HashMap<>();
        this.userMap = new HashMap<>();
    }

    public void save(User user) {
        if(userMap.containsKey(user.getId())) {
            throw new RuntimeException("User already exists");
        }
        users.add(user);
        userMap.put(user.getId(), user);
    }

    public User getUser(Integer id) {
        return userMap.getOrDefault(id,null);
    }

    public void addFriends(Integer userId, List<User> friends) {
        friends.forEach(friend -> {
            if(!userMap.containsKey(friend.getId())) {
                throw new RuntimeException("User does not exist with id : " + friend.getId());
            }
        });
        users.get(userId).getFriends().addAll(friends);
    }

    public List<User> getAllUsersById(List<Integer> ids) {
//        List<User> users = new ArrayList<>();
//        ids.forEach(id ->
//        {
//            if(userMap.get(id)!=null)users.add(userMap.get(id));
//        });
        return ids.stream().map(userMap::get).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<User> getFriends(User user) {
        return friends.getOrDefault(user,null);
    }
}
