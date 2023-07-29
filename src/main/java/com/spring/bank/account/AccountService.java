package com.spring.bank.account;

public interface AccountService {

    void createAccount(String accountNumber);

    void removeAccount(String accountNumber);

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void getBalance(String accountNumber);

}
