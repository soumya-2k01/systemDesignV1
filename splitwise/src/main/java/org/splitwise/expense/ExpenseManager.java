package org.splitwise.expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.splitwise.User.User;

@Getter
@Setter
public class  ExpenseManager {
    List<Expense> expenseList;
    public ExpenseManager(){
        expenseList = new ArrayList<>();
    }
    public void createExpense(Double amount, User paidBy, Split type, List<User> borrowers) throws Exception {

        Expense expense = ExpenseFactory.getExpense(amount, paidBy,type, borrowers, null);
        if(expense==null)throw new Exception("Error creating Expense");
        if(!expense.validateExpense()){
            throw new RuntimeException("Invalid expense");
        }
        expenseList.add(expense);
    }

    public void createExpense(Double amount, User paidBy, Split type, Map<User, Double> splitAmt) throws Exception {

        Expense expense = ExpenseFactory.getExpense(amount, paidBy,type, null, splitAmt);
        if(expense==null)throw new Exception("Error creating Expense");
        if(!expense.validateExpense()){
            throw new RuntimeException("Invalid expense");
        }
        expenseList.add(expense);
    }
}
