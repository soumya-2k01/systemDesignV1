package org.splitwise.expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.splitwise.User.User;

public class UnequalExpense implements Expense{
    Double amount;
    User paidBy;
    Split splitType;
    Map<User, Double> splits;

    public UnequalExpense(Double amount, User paidBy, Map<User,Double> borrowersWithAmt){
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = Split.UNEQUAL;
        this.splits = borrowersWithAmt;
    }
    @Override
    public boolean validateExpense() {
        double sum = 0;
        for(Map.Entry<User, Double> entry: splits.entrySet()){
            sum+=entry.getValue();
        }
        if(amount-sum<0.1){
            Map.Entry<User, Double> firstEntry = splits.entrySet().iterator().next();
            firstEntry.setValue(firstEntry.getValue()+(amount-sum));
            splits.put(firstEntry.getKey(), firstEntry.getValue());
            return true;
        }
        return false;
    }
}
