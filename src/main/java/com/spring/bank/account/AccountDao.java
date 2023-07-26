package com.spring.bank.account;

import com.spring.bank.account.Account;

public interface AccountDao {

    void createAccount(Account account);

    void updateAccount(Account account);

    void removeAccount(Account account);

    Account findAccount(String accountNumber);

}
