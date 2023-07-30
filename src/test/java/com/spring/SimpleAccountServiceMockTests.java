package com.spring;

import com.spring.bank.account.AccountDao;
import org.junit.jupiter.api.BeforeEach;

public class SimpleAccountServiceMockTests {

    private static final String TEST_ACCOUNT_NO = "1234";

    private AccountDao accountDao;

    private SimpleAccountService accountService;

    @BeforeEach
    public void init() {
        accountDao = mock(AccountDao.class);
        accountService = new SimpleAccountService(accountDao);
    }

    @Test
    void deposit() {
        var account = new Account(TEST_ACCOUNT_NO);
        when(accountDao.findAccount(TEST_ACCOUNT_NO)).thenReturn(account);
        accountService.deposit(TEST_ACCOUNT_NO, 100);
        verify(accountDao, times(1)).findAccount(any(String.class));
        verify(accountDao, times(1)).updateAccount(account);
    }

    @Test
    void withdrawWithSufficientBalance() {
        var account = new Account(TEST_ACCOUNT_NO, 100);
        when(accountDao.findAccount(TEST_ACCOUNT_NO)).thenReturn(account);
        accountService.withdraw(TEST_ACCOUNT_NO, 100);
        verify(accountDao, times(1)).findAccount(any(String.class));
        verify(accountDao, times(1)).updateAccount(account);
    }

    @Test
    void withdrawWithInsufficientBalance() {
        var account = new Account(TEST_ACCOUNT_NO, 100);
        when(accountDao.findAccount(TEST_ACCOUNT_NO)).thenReturn(account);
        assertThrows(InsufficientBalanceException.class, () -> {
            accountService.withdraw(TEST_ACCOUNT_NO, 200);
        });
        verify(accountDao, times(1)).findAccount(any(String.class));
        verify(accountDao, never()).updateAccount(any(Account.class));
    }

}
