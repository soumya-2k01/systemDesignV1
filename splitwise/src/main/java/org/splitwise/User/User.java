package org.splitwise.User;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.splitwise.BalanceSheet;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Integer userId;
    private String username;
    private List<User> friends;
    private BalanceSheet balanceSheet;
}
