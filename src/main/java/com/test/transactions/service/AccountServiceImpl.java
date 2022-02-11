package com.test.transactions.service;


import com.test.transactions.domain.Account;
import com.test.transactions.domain.Transaction;
import com.test.transactions.dto.TransactionDTO;
import com.test.transactions.exceptions.Status402UserToDontHaveNeededAmount;
import com.test.transactions.repository.AccountsRepository;
import com.test.transactions.repository.StatusRepository;
import com.test.transactions.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountServiceImpl implements AccountService{

    AccountsRepository accountRepository;
    TransactionsRepository transactionRepository;
    StatusRepository statusRepository;

    @Autowired
    public AccountServiceImpl(AccountsRepository accountRepository, TransactionsRepository transactionRepository, StatusRepository statusRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.statusRepository = statusRepository;
    }


    public Account save(Account account){
        accountRepository.save(account);
        return accountRepository.findAccountByIdEquals(account.getId());
    }

    @Override
    public void transferMoney(Transaction transaction) throws Status402UserToDontHaveNeededAmount {

        Long fromAccountId = transaction.getAccountFrom();
        Long toAccountId = transaction.getAccountTo();
        Long amount = transaction.getAmount();

        Account fromAccount = accountRepository.findAccountByIdEquals(fromAccountId);
        Account toAccount = accountRepository.findAccountByIdEquals(toAccountId);

        if (Math.signum(fromAccount.getAmount() - amount) != 1.0){
            throw new Status402UserToDontHaveNeededAmount();
        }
        fromAccount.setAmount(fromAccount.getAmount() - amount);
        accountRepository.save(fromAccount);
        toAccount.setAmount(toAccount.getAmount() + amount);
        accountRepository.save(toAccount);

//        Long transferStatus = statusRepository.findValueById(1L).getId();

//        Ignoring initiator name inheriting because it can be better used with basic Spring Auth
        transactionRepository.save(new TransactionDTO(
                0L, fromAccountId, toAccountId, amount, "John Doe", 1L));


    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

}
