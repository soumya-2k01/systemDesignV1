package com.app.splitwise.Service;

import com.app.splitwise.Model.ExpenseRequest;
import com.app.splitwise.entity.BalanceSheet;
import com.app.splitwise.entity.Expense;
import com.app.splitwise.entity.Group;
import com.app.splitwise.entity.User;
import com.app.splitwise.manager.ExpenseManager;
import com.app.splitwise.split.Split;
import com.app.splitwise.split.SplitFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExpenseService {
    @Autowired
    private ExpenseManager expenseManager;
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private BalanceSheetService balanceSheetService;

    public void createExpense(ExpenseRequest expenseReq) {
        Group group = groupService.getGroup(expenseReq.getGroupId());
        if(group == null) {
            throw new RuntimeException("Group does not exist for this id");
        }
        Split split = SplitFactory.getInstance().getSplitByType(expenseReq.getSplitType());

        Expense expense = new Expense();
        expense.setId(expenseReq.getId());
        expense.setTitle(expenseReq.getTitle());
        expense.setGroupId(group.getId());
        expense.setAmount(expenseReq.getAmount());
        expense.setPaidBy(expenseReq.getPaidBy());
        List<User> users = userService.getAllUsersById(expenseReq.getSplitAmong());
        expense.setSplitAmountAgainstUser(split.doSplit(users, expenseReq.getAmount(), expenseReq.getSplitAmounts()));
        expenseManager.createExpense(expense);
        try {
            balanceSheetService.updateBalanceSheet(expense);
        } catch(Exception e) {
            log.info("Error while updating balance sheet. Couldn't create balance sheet");
        }
    }

    public BalanceSheet viewBalanceSheetDetails(Integer userId) {
        return balanceSheetService.getBalanceSheetForUser(userId);
    }

}
