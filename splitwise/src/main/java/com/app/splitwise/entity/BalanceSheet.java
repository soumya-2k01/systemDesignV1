package com.app.splitwise.entity;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class BalanceSheet {
    Integer id;
    Integer userId;
    Map<User, Balance> friendsBalance;
    Double totalDebit;
    Double totalCredit;

    public BalanceSheet() {
        this.friendsBalance = new HashMap<>();
        this.totalDebit = 0.0;
        this.totalCredit = 0.0;
    }
}
