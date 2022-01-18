package com.kata.bank.service;

import com.kata.bank.entity.Operation;
import com.kata.bank.enumaration.TypeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {

    private int balance;

    private List<Operation> operations = new ArrayList<>();

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
        this.operations.add(new Operation(TypeOperation.DEPOSIT, amount, this.balance));
    }

    @Override
    public void withdrawal(int amount) {
        if (amount > this.balance) {
            throw new UnsupportedOperationException("No enough founds");
        }
        this.balance -= amount;
        this.operations.add(new Operation(TypeOperation.WITHDRAWAL, amount, this.balance));
    }

    @Override
    public String printOperations() {
        return this.operations.stream().map(Operation::toString).collect(Collectors.joining("\n"));
    }
}
