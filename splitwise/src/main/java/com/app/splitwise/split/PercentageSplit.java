package com.app.splitwise.split;

import com.app.splitwise.entity.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageSplit implements Split {
    @Override
    public boolean validate(List<Double> splits, Double total) {
         double sum = 0;
         for(Double value: splits) {
             sum+=value;
         }
         return sum==total;
    }

    @Override
    public Map<User, Double> doSplit(List<User> splitBetweenUsers, Double totalAmount, List<Double> splitAmounts) {
        if(!validate(splitAmounts, totalAmount) || splitBetweenUsers.size()!=splitAmounts.size()){
            throw new RuntimeException("400, Incorrect splits");
        }
        Map<User, Double> splitsAgainstUser = new HashMap<>();
        for(int i=0; i<splitBetweenUsers.size(); i++) {
            splitsAgainstUser.put(splitBetweenUsers.get(i),splitAmounts.get(i)*totalAmount/100);
        }
        return splitsAgainstUser;
    }
}
