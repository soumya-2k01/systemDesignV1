package com.app.splitwise.manager;

import com.app.splitwise.entity.Expense;
import com.app.splitwise.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class ExpenseManager {
    List<Expense> expenses;
    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void createExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getAllExpensesByGroup(Integer groupId) {
        return expenses.stream().filter(expense -> expense.getGroupId().equals(groupId)).collect(Collectors.toList());
    }

    public List<Expense> getAllExpensesByUser(User user) {
        return expenses.stream().filter(expense -> expense.getPaidBy().equals(user)).collect(Collectors.toList());
    }

    public List<Expense> getAllExpensesOfPayeeByGroup(User user, Integer groupId) {
        return expenses.stream().filter(expense -> expense.getGroupId().equals(groupId)
                                        && expense.getPaidBy().equals(user)).collect(Collectors.toList());
    }



}
