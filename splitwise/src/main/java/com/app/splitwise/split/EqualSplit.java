package com.app.splitwise.split;

import com.app.splitwise.entity.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements Split {
    @Override
    public boolean validate(List<Double> splits, Double total) {
        return true;
    }

    @Override
    public Map<User, Double> doSplit(List<User> splitBetweenUsers, Double totalAmount, List<Double> splitAmounts) {
        Map<User, Double> splitsAgainstUser = new HashMap<>();
        double perPersonAmount = totalAmount/splitBetweenUsers.size();
        splitBetweenUsers.forEach(user -> {
            splitsAgainstUser.put(user,perPersonAmount);
        });
        return splitsAgainstUser;
    }

}
