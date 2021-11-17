package com.example.future_bank.service;

import com.example.future_bank.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceDblmplTest {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountService accountService;

    @Test
    public void should_Return_Not_Null(){
        assertNotNull(accountService.getAllAccount());
    }
}