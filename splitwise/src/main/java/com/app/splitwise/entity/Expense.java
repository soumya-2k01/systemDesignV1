package com.app.splitwise.entity;

import com.app.splitwise.split.SplitType;
import java.util.Map;
import lombok.Data;

@Data
public class Expense {
    Integer id;
    String title;
    Integer groupId;
    Double amount;
    Map<User,Double> splitAmountAgainstUser;
    User paidBy;

    @Override
    public int hashCode() {
        return this.id;
    }

}
