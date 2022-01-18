package com.kata.bank.entity;

import com.kata.bank.enumaration.TypeOperation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {

    private TypeOperation typeOperation;
    private int amount;
    private int balance;

    public Operation(TypeOperation typeOperation, int amount, int balance) {
        this.typeOperation = typeOperation;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s of %d - DATE : %s - BALANCE : %d", typeOperation, amount, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), balance);
    }

}
