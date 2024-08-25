package com.app.splitwise.split;

import com.app.splitwise.entity.User;
import java.util.List;
import java.util.Map;

public interface Split {
    boolean validate(List<Double> splits, Double total);
    Map<User, Double> doSplit(List<User> splitBetweenUsers, Double totalAmount, List<Double> splitAmounts);

}
