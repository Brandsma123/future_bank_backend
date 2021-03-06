package com.example.future_bank.service;

import com.example.future_bank.entity.Account;

import java.awt.print.Pageable;
import java.util.List;

public interface AccountService {
    public List<Account> getAllAccount();
    public Account getAccountById(String id);
    public Account registerAccount(Account account);
    public void deleteAccount(String id);
    public void updateAccount(Account account);
}
