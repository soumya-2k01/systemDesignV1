package com.app.splitwise.Controller;

import com.app.splitwise.Model.ExpenseRequest;
import com.app.splitwise.Service.BalanceSheetService;
import com.app.splitwise.Service.ExpenseService;
import com.app.splitwise.entity.BalanceSheet;
import com.app.splitwise.manager.ExpenseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    public ExpenseService expenseService;
//    @Autowired
//    public ExpenseManager expenseManager;

    @PostMapping("/create")
    public ResponseEntity createExpense(@RequestBody ExpenseRequest expenseRequest) {
        expenseService.createExpense(expenseRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/viewBalance")
    public BalanceSheet viewBalanceSheet(@RequestParam Integer userId) {
        return expenseService.viewBalanceSheetDetails(userId);
    }
}
