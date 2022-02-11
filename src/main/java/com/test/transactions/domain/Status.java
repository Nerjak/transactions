package com.test.transactions.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="status")
@Getter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String status;
}
