package com.spring.bank.account;

import com.spring.bank.exceptions.InsufficientBalanceException;

class SimpleAccountService implements AccountService{

    private final AccountDao accountDao;

    public SimpleAccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void createAccount(String accountNumber) {
        accountDao.createAccount(new Account(accountNumber, 0));
    }

    @Override
    public void removeAccount(String accountNumber) {
        accountDao.removeAccount(accountDao.findAccount(accountNumber));
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        var account = accountDao.findAccount(accountNumber);
        account.setBalance(account.getBalance() + amount);
        accountDao.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        var account = accountDao.findAccount(accountNumber);
        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException();
        }
        account.setBalance(account.getBalance() - amount);
        accountDao.updateAccount(account);
    }

    @Override
    public void getBalance(String accountNumber) {
        var account = accountDao.findAccount(accountNumber);
        System.out.println(account.getBalance());
    }
}
