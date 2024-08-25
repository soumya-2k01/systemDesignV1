package com.app.splitwise.Model;

import com.app.splitwise.entity.User;
import com.app.splitwise.split.SplitType;
import java.util.List;
import lombok.Data;

@Data
public class ExpenseRequest {
    Integer id;
    String title;
    Integer groupId;
    Double amount;
    SplitType splitType;
    List<Integer> splitAmong;
    List<Double> splitAmounts;
    User paidBy;
}
