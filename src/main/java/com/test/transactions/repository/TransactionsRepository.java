package com.test.transactions.repository;

import com.test.transactions.domain.Transaction;
import com.test.transactions.dto.TransactionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionDTO, Long> {

}
