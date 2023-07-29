package com.spring.bank.account;

public interface AccountService {

    void createAccount(Account account);

    void createAccount(String accountNumber);

    void removeAccount(Account account);

    void removeAccount(String accountNumber);

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void getBalance(String accountNumber);

}
