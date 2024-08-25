package com.app.splitwise.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public class User {
    Integer id;
    String name;
    List<User> friends;
    BalanceSheet balanceSheet;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.friends = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
