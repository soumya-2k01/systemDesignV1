package org.rental;

import java.util.ArrayList;
import org.rental.store.Store;
import org.rental.store.StoreManager;

import java.util.List;

public class CarRentalSystem {
    public StoreManager storeManager;
    public List<User> users;

    public CarRentalSystem(List<Store> stores){
        this.storeManager = new StoreManager(stores);
        this.users = new ArrayList<>();
    }
    public void addUser(User user){
        users.add(user);
        System.out.println("User added");
    }

    public void removeUser(User user){
        users.remove(user);
        System.out.println("User removed");
    }
}
