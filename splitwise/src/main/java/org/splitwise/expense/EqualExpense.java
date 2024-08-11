package org.splitwise.expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.splitwise.User.User;

public class EqualExpense implements Expense {
    Double amount;
    User paidBy;
    Split splitType;
    Map<User, Double> splits;

    public EqualExpense(Double amount, User paidBy, List<User> borrowers){
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = Split.EQUAL;
        this.splits = new HashMap<>();
        for(User user: borrowers){
            splits.put(user, amount/borrowers.size());
        }
    }

    @Override
    public boolean validateExpense() {
        double sum = 0;
        for(Map.Entry<User, Double> entry: splits.entrySet()){
            sum+=entry.getValue();
        }
        if(amount==sum)return true;
        else if(amount-sum<0.1){
            Map.Entry<User, Double> firstEntry = splits.entrySet().iterator().next();
            firstEntry.setValue(firstEntry.getValue()+(amount-sum));
            splits.put(firstEntry.getKey(), firstEntry.getValue());
            return true;
        }
        return false;
    }
}
