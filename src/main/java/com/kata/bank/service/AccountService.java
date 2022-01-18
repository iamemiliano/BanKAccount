package com.kata.bank.service;

public interface AccountService {
    int getBalance();

    void deposit(int amount);

    void withdrawal(int amount);

    String printOperations();
}
