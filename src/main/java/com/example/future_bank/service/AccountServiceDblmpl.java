package com.example.future_bank.service;

import com.example.future_bank.entity.Account;
import com.example.future_bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceDblmpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    @Override
    public Account RegisterAccount(Account account) {
        return null;
    }

    @Override
    public Account getAccountById() {
        return null;
    }
}
