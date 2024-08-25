package com.app.splitwise.Service;

import com.app.splitwise.entity.Balance;
import com.app.splitwise.entity.BalanceSheet;
import com.app.splitwise.entity.Expense;
import com.app.splitwise.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class BalanceSheetService {
    List<BalanceSheet> balanceSheets;

    public BalanceSheetService() {
        this.balanceSheets = new ArrayList<>();
    }

    public User createBalanceSheet(User user) {
        BalanceSheet sheet = new BalanceSheet();
        sheet.setId(user.getId()*1000);
        sheet.setUserId(user.getId());
        sheet.setFriendsBalance(new HashMap<>());
        sheet.setTotalDebit(0.0);
        sheet.setTotalCredit(0.0);
        user.setBalanceSheet(sheet);
        balanceSheets.add(sheet);
        return user;
    }

    public BalanceSheet getBalanceSheetForUser(Integer userId) {
        for(BalanceSheet sheet : balanceSheets) {
            if(sheet.getUserId().equals(userId)) return sheet;
        }
        return null;
    }

    public void updateBalanceSheet(Expense expense) {
        User payer = expense.getPaidBy();
        Map<User,Double> owers = expense.getSplitAmountAgainstUser();
        for(Map.Entry<User, Double> ower: owers.entrySet()) {
            BalanceSheet sheet = ower.getKey().getBalanceSheet();
            if(ower.getKey().equals(payer)) {
                setPayerBalanceSheet(expense);
            }
            Balance balance = sheet.getFriendsBalance().getOrDefault(payer, new Balance());
            balance.setOweAmount(balance.getOweAmount()+ower.getValue());
            sheet.getFriendsBalance().put(payer,balance);
            sheet.setTotalDebit(sheet.getTotalDebit() + balance.getOweAmount());
        }
    }

    private void setPayerBalanceSheet(Expense expense) {
        User payer = expense.getPaidBy();
        Map<User,Double> owers = expense.getSplitAmountAgainstUser();
        BalanceSheet sheet = payer.getBalanceSheet();
        for(Map.Entry<User, Double> entry: owers.entrySet()) {
            if(entry.getKey().equals(payer))continue;
            Balance balance = sheet.getFriendsBalance().getOrDefault(entry.getKey(), new Balance());
            balance.setGetBackAmount(balance.getGetBackAmount()+entry.getValue());
            sheet.getFriendsBalance().put(entry.getKey(),balance);
            sheet.setTotalCredit(sheet.getTotalCredit() + entry.getValue());
        }
    }
}
