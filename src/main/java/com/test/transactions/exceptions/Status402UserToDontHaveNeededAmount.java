package com.test.transactions.exceptions;

public class Status402UserToDontHaveNeededAmount extends Exception{
    public static final String CODE = "402";

    public Status402UserToDontHaveNeededAmount() {
        super(CODE + ":" + "Invalid requestId");
    }
}
