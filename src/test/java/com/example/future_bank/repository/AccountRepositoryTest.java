package com.example.future_bank.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    public void rest (){
        accountRepository.deleteAllAccount();
    }

    @Test
    @Transactional
    public void Able_To_Insert_Data(){
        accountRepository.RegisterAccount("3423","brandsma","bra@gmail.com","534543","jakarta","dsa","6866","asdsa","asdsa");
    assertEquals(1,accountRepository.getAllAccount().size());
    }

    @Test
    @Transactional
    public void should_Return_True_when_Giving_Correct_Id(){
        accountRepository.RegisterAccount("3423","brandsma","bra@gmail.com","534543","jakarta","dsa","6866","asdsa","asdsa");
    assertNotNull(accountRepository.getAccountById("3423"));
    }

    @Test
    @Transactional
    public void should_Return_False_when_Giving_Incorrect_Id(){
        accountRepository.RegisterAccount("3423","brandsma","bra@gmail.com","534543","jakarta","dsa","6866","asdsa","asdsa");
        assertNull(accountRepository.getAccountById("3324423"));
    }

    @Test
    @Transactional
    public void should_Return_True_when_Giving_Correct_Username(){
        accountRepository.RegisterAccount("3423","brandsma","bra@gmail.com","534543","jakarta","dsa","6866","asdsa","asdsa");
        assertNotNull(accountRepository.findAccountByUserName("brandsma"));
    }

    @Test
    @Transactional
    public void able_To_Delete_Account_By_Id(){
        accountRepository.RegisterAccount("3423","brandsma","bra@gmail.com","534543","jakarta","dsa","6866","asdsa","asdsa");
    accountRepository.deleteAccountById("3423");
    assertEquals(0, accountRepository.getAllAccount().size());
    }

    @Test
    @Transactional
    public void notAble_To_Delete_Account_By_Id_When_Given_Incorect_Id(){
        accountRepository.RegisterAccount("3423","brandsma","bra@gmail.com","534543","jakarta","dsa","6866","asdsa","asdsa");
        accountRepository.deleteAccountById("34254343");
        assertEquals(1, accountRepository.getAllAccount().size());
    }


}