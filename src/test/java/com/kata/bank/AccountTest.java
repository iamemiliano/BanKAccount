package com.kata.bank;

import com.kata.bank.service.AccountService;
import com.kata.bank.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    private AccountService bankAccount;

    @Before
    public void setUp() {
        this.bankAccount = new AccountServiceImpl();
    }

    @Test
    public void shouldHaveEmptyBalance_WhenStartup() {
        assertEquals(0.0, bankAccount.getBalance(),  0);
    }

    @Test
    public void shouldHave20IntoBalance_WhenDipositing20() {
        this.bankAccount.deposit(20);
        assertEquals(20, this.bankAccount.getBalance(), 0);
    }

    @Test
    public void shouldHave35IntoBalance_WhenDipositing20AndDipositing15() {
        this.bankAccount.deposit(20);
        this.bankAccount.deposit(15);
        assertEquals(35, this.bankAccount.getBalance(),  0);
    }

    @Test
    public void shouldHaveBalance5_WhenDeposit20AndWithdrawal15() {
        this.bankAccount.deposit(20);
        this.bankAccount.withdrawal(15);
        assertEquals(5, this.bankAccount.getBalance(), 0);
    }

    @Test
    public void shouldPrintOneOperations_WhenDepositing10AndPrintingOperations() {
        this.bankAccount.deposit(10);
        String result = this.bankAccount.printOperations();
        assertTrue(result.contains(this.history("DEPOSIT", 10, 10)));
    }

    @Test
    public void shouldPrintFourOperations_WhenExecutingFourOperations() {
        this.bankAccount.deposit(25);
        this.bankAccount.withdrawal(10);
        this.bankAccount.withdrawal(15);
        this.bankAccount.deposit(40);
        String result = this.bankAccount.printOperations();
        assertTrue(result.contains(this.history("DEPOSIT", 25, 25)));
        assertTrue(result.contains(this.history("WITHDRAWAL", 10, 15)));
        assertTrue(result.contains(this.history("WITHDRAWAL", 15, 0)));
        assertTrue(result.contains(this.history("DEPOSIT", 40, 40)));
    }


    private String history(String operation, int amount, int balance) {
        return String.format("%s of %d - DATE : %s - BALANCE : %d", operation, amount, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), balance);
    }


}
