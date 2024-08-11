package org.splitwise.User;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.splitwise.expense.Expense;

@Getter
@Setter
@AllArgsConstructor
public class Group {
    Integer groupId;
    String groupName;
    List<User> members;
    List<Expense> expenseList;
}
