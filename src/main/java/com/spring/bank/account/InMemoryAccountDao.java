package com.spring.bank.account;

import com.spring.bank.exceptions.AccountNotFoundExceptions;
import com.spring.bank.exceptions.DuplicateAccountException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccountDao implements AccountDao {

    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public boolean accountExists(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }


    @Override
    public void createAccount(Account account) {
        if (accountExists(account.getAccountNumber())) {
            throw new DuplicateAccountException();
        }
        accounts.put(account.getAccountNumber(), account);
    }

    @Override
    public void updateAccount(Account account) {
        if (!accountExists(account.getAccountNumber())) {
            throw new AccountNotFoundExceptions();
        }
        accounts.put(account.getAccountNumber(), account);
    }

    @Override
    public void removeAccount(Account account) {
        if (!accountExists(account.getAccountNumber())) {
            throw new AccountNotFoundExceptions();
        }
        accounts.remove(account.getAccountNumber());
    }

    @Override
    public Account findAccount(String accountNumber) {
        var account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundExceptions();
        }
        return account;
    }
}
