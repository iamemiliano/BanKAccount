package com.kata.bank.service;

import com.kata.bank.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private int balance;

    private List<Operation> operations = new ArrayList<Operation>();

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
        this.operations.add(new Operation("DEPOSIT", amount, this.balance));
    }

    @Override
    public void withdrawal(int amount) {
        if (amount > this.balance) {
            throw new UnsupportedOperationException("No enough founds");
        }
        this.balance -= amount;
        this.operations.add(new Operation("WITHDRAWAL", amount, this.balance));
    }

    @Override
    public String printOperations() {
        StringBuilder result = new StringBuilder("");
        for (Operation operation: this.operations) {
            result.append(operation.toString());
            result.append("\n");
        }
        return result.toString();
    }
}
