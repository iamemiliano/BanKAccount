package com.kata.bank.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {

    private String typeOperation;
    private int amount;
    private int balance;

    public Operation(String typeOperation, int amount, int balance) {
        this.typeOperation = typeOperation;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s of %d - DATE : %s - BALANCE : %d", typeOperation, amount, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), balance);
    }

}
