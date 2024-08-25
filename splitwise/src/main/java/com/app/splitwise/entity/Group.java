package com.app.splitwise.entity;

import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public class Group {
    Integer id;
    String name;
    List<User> members;
    List<Expense> expenses;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
