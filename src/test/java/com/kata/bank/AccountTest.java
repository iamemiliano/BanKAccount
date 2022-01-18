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
    public void should_have_empty_balance_when_startup() {
        assertEquals(0.0, bankAccount.getBalance(),  0);
    }

    @Test
    public void should_have20_into_balance_when_dipositing20() {
        this.bankAccount.deposit(20);
        assertEquals(20, this.bankAccount.getBalance(), 0);
    }

    @Test
    public void should_have35_intoBalance_when_dipositing20_and_dipositing15() {
        this.bankAccount.deposit(20);
        this.bankAccount.deposit(15);
        assertEquals(35, this.bankAccount.getBalance(),  0);
    }

    @Test
    public void should_have_balance5_when_deposit20_and_withdrawal15() {
        this.bankAccount.deposit(20);
        this.bankAccount.withdrawal(15);
        assertEquals(5, this.bankAccount.getBalance(), 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_throwException_when_deposit10_and_withdrawal11() {
        this.bankAccount.deposit(20);
        this.bankAccount.withdrawal(25);
    }

    @Test
    public void should_have_exceptionbalance5_when_deposit20_and_withdrawal15() {
        this.bankAccount.deposit(20);
        this.bankAccount.withdrawal(15);
        assertEquals(5, this.bankAccount.getBalance(), 0);
    }

    @Test
    public void should_print_oneOperations_when_depositing10_and_printingOperations() {
        this.bankAccount.deposit(10);
        String result = this.bankAccount.printOperations();
        assertTrue(result.contains(this.history("DEPOSIT", 10, 10)));
    }

    @Test
    public void should_print_fourOperations_when_executing_fourOperations() {
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
