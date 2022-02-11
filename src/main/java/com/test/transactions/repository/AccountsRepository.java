package com.test.transactions.repository;

import com.test.transactions.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {
    Account findAccountByIdEquals(Long id);
}
