package com.spring;

import com.spring.bank.account.Account;
import com.spring.bank.account.InMemoryAccountDao;
import com.spring.bank.exceptions.AccountNotFoundExceptions;
import com.spring.bank.exceptions.DuplicateAccountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryAccountDaoTests {

    private static final String EXISTING_ACCOUNT_NO = "1234";

    private static final String NEW_ACCOUNT_NO = "5678";

    private Account existingAccount;

    private Account newAccount;

    private InMemoryAccountDao accountDao;

    @BeforeEach
    void init() {
        existingAccount = new Account(EXISTING_ACCOUNT_NO, 100);
        newAccount = new Account(NEW_ACCOUNT_NO, 200);
        accountDao = new InMemoryAccountDao();
        accountDao.createAccount(existingAccount);
    }

    @Test
    void accountExists() {
        assertTrue(accountDao.accountExists(EXISTING_ACCOUNT_NO));

    }

    @Test
    void createNewAccount() {
        accountDao.createAccount(newAccount);
        assertEquals(newAccount, accountDao.findAccount(NEW_ACCOUNT_NO));
    }

    @Test
    void createDuplicateAccount() {
        assertThrows(DuplicateAccountException.class, () -> accountDao.createAccount(existingAccount));
    }

    @Test
    void updateExistingAccount() {
        existingAccount.setBalance(150);
        accountDao.updateAccount(existingAccount);
        assertEquals(existingAccount, accountDao.findAccount(EXISTING_ACCOUNT_NO));
    }

    @Test
    void updateNonExistingAccount() {
        assertThrows(AccountNotFoundExceptions.class, () -> accountDao.updateAccount(newAccount));
    }

    @Test
    void removeExistingAccount() {
        accountDao.removeAccount(existingAccount);
        assertFalse(accountDao.accountExists(EXISTING_ACCOUNT_NO));
    }

    @Test
    void removeNonExistingAccount() {
        assertThrows(AccountNotFoundExceptions.class, () -> accountDao.removeAccount(newAccount));
    }

    @Test
    void findExistingAccount() {
        var account = accountDao.findAccount(EXISTING_ACCOUNT_NO);
        assertEquals(existingAccount, account);
    }

    @Test
    void findNonExistingAccount() {
        assertThrows(AccountNotFoundExceptions.class, () -> accountDao.findAccount(NEW_ACCOUNT_NO));
    }


}
