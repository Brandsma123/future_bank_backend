package com.example.future_bank.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    public void  reset(){
        accountRepository.deleteAllAccount();
    }

    @Test
    public void able_To_Insert_Account(){
        accountRepository.RegisterAccount("423","afsdfsd","fsdf","dsadsa","sdfsd","sfdsf","sdfdsds", "fdsf", "fsd");
    assertEquals(1, accountRepository.getAllAccount().size());
    }
}
