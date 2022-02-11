package com.test.transactions.domain;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Transaction {
    Long accountFrom;
    Long accountTo;
    Long amount;

}
