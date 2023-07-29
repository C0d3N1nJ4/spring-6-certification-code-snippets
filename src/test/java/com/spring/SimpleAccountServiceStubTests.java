package com.spring;

import com.spring.bank.account.AccountDao;
import com.spring.bank.account.SimpleAccountService;
import com.spring.bank.account.Account;
import com.spring.bank.exceptions.InsufficientBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleAccountServiceStubTests {

    private static final String TEST_ACCOUNT_NO = "1234";

    private AccountDaoStub accountDaoStub;

    private SimpleAccountService accountService;

    @BeforeEach
    public void init() {
        accountDaoStub = new AccountDaoStub();
        accountDaoStub.accountNumber = TEST_ACCOUNT_NO;
        accountDaoStub.balance = 100;
        accountService = new SimpleAccountService(accountDaoStub);
    }

    @Test
    public void deposit() {
        accountService.deposit(TEST_ACCOUNT_NO, 50);
        assertEquals(TEST_ACCOUNT_NO, accountDaoStub.accountNumber);
        assertEquals(150, accountDaoStub.balance, 0);
    }

    @Test
    public void withdrawWithSufficientBalance() {
        accountService.withdraw(TEST_ACCOUNT_NO, 50);
        assertEquals(TEST_ACCOUNT_NO, accountDaoStub.accountNumber);
        assertEquals(50, accountDaoStub.balance, 0);
    }

    @Test
    public void withdrawWithInsufficientBalance() {
        assertThrows(InsufficientBalanceException.class, () -> accountService.withdraw(TEST_ACCOUNT_NO, 150));
    }

    /**
     * Partially implemented stub implementation for the {@code AccountDao}
     */


    private static class AccountDaoStub implements AccountDao {

        private String accountNumber;

        private double balance;

        public void createAccount(Account account) {

        }

        public void updateAccount(Account account) {
            this.accountNumber = account.getAccountNumber();
            this.balance = account.getBalance();
        }

        public void removeAccount(Account account) {

        }

        public Account findAccount(String accountNumber) {
            return new Account(this.accountNumber, this.balance);
        }
    }
}
