package com.example.future_bank.service;

import com.example.future_bank.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceDblmplTest {

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository accountRepository;

}