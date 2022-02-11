package com.test.transactions.controller;

import com.test.transactions.domain.Transaction;
import com.test.transactions.exceptions.Status402UserToDontHaveNeededAmount;
import com.test.transactions.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/transaction")
public class TransactionController {

    AccountService accountService;
    @Autowired
    public TransactionController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/transfer")
    private void sendMoney(@RequestBody Transaction transaction)
            throws Status402UserToDontHaveNeededAmount {
        accountService.transferMoney(transaction);
    }

}
