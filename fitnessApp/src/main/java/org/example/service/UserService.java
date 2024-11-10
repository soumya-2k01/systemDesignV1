package org.example.service;

import java.util.HashSet;
import java.util.Set;
import org.example.entity.User;

public class UserService {
    private Set<User> users;

    private Set<Integer> userIds;

    public UserService() {
        users = new HashSet<>();
        userIds = new HashSet<>();
    }

    public String register(User user) {
        if(userIds.contains(user.getId())) {
            throw new RuntimeException("This user is already registered");
        }
        user.setAuthKey(user.getName()+user.getId());
        users.add(user);
        userIds.add(user.getId());
        return user.getAuthKey();
    }

    public void login(User user, String authKey) {
        if(!userIds.contains(user.getId())) {
            throw new RuntimeException("This user is not registered");
        }
        if(user.getAuthKey().equals("") || !user.getAuthKey().equals(authKey)) {
            throw new RuntimeException("Wrong authentication key");
        }
        user.setLoggedIn(true);
        System.out.println("Logged in successfully");
    }

    //Logout

    public boolean validateUserEligibility(User user) {
        if(!user.isLoggedIn()) {
            throw new RuntimeException("User not logged in");
        }
        if(user.getBookingsCount() >= user.getTier().getLimit()) {
            throw new RuntimeException("Booking limit reached. Cannot book more classes");
        }
        return true;
    }

}
