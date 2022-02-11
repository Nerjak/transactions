package com.test.transactions.service;

import com.test.transactions.domain.Account;
import com.test.transactions.domain.Transaction;
import com.test.transactions.exceptions.Status402UserToDontHaveNeededAmount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
    void transferMoney(Transaction transaction) throws Status402UserToDontHaveNeededAmount;
}
