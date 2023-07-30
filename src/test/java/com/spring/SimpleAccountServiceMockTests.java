package com.spring;

import com.spring.bank.account.Account;
import com.spring.bank.account.AccountDao;
import com.spring.bank.account.SimpleAccountService;
import com.spring.bank.exceptions.InsufficientBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimpleAccountServiceMockTests {

    private static final String TEST_ACCOUNT_NO = "1234";

    @Mock
    private AccountDao accountDao;

    @InjectMocks
    private SimpleAccountService accountService;

//    @BeforeEach
//    public void init() {
//        accountDao = mock(AccountDao.class);
//        accountService = new SimpleAccountService(accountDao);
//    }

    @Test
    void deposit() {
        var account = new Account(TEST_ACCOUNT_NO, 100);
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
        assertThrows(InsufficientBalanceException.class, () -> accountService.withdraw(TEST_ACCOUNT_NO, 200));
        verify(accountDao, times(1)).findAccount(any(String.class));
        verify(accountDao, never()).updateAccount(any(Account.class));
    }

}
