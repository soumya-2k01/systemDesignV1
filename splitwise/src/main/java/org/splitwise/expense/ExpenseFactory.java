package org.splitwise.expense;

import java.util.List;
import java.util.Map;
import org.splitwise.User.User;

public class ExpenseFactory {

    public static Expense getExpense(Double amount, User paidBy, Split splitType, List<User> borrowers,
            Map<User, Double> splitAmt){
        switch (splitType){
            case EQUAL: return new EqualExpense(amount, paidBy, borrowers);
            case UNEQUAL: return new UnequalExpense(amount, paidBy, splitAmt);
            case PERCENTAGE:
            default: return null;
        }
    }
}
