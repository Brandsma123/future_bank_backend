package com.example.future_bank.service;

import com.example.future_bank.entity.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAllAccount();
    public void registerAccount(Account account);
    public Account getAccountById();
}
