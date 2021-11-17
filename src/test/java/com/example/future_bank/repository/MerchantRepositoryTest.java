package com.example.future_bank.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MerchantRepositoryTest {

    @Autowired
    MerchantRepository merchantRepository;

    @BeforeEach
    public void rest (){
        merchantRepository.deleteAllMerchant();
    }

    @Test
    @Transactional
    public void Able_To_Insert_Data(){
        merchantRepository.createMerchant("43232","brandsma",10000);
        assertEquals(1,merchantRepository.getAllMerchant().size());
    }

    @Test
    @Transactional
    public void should_Return_True_when_Giving_Correct_Id(){
        merchantRepository.createMerchant("42432","sadsads",1000);
        assertNotNull(merchantRepository.getMerchantById("42432"));
    }

    @Test
    @Transactional
    public void should_Return_False_when_Giving_Incorrect_Id(){
        merchantRepository.createMerchant("42432","sadsads",1000);
        assertNull(merchantRepository.getMerchantById("3324423"));
    }


    @Test
    @Transactional
    public void able_To_Delete_Merchant_By_Id(){
        merchantRepository.createMerchant("42432","sadsads",1000);
        merchantRepository.deleteMerchantById("42432");
        assertEquals(0, merchantRepository.getAllMerchant().size());
    }

    @Test
    @Transactional
    public void notAble_To_Delete_Merchant_By_Id_When_Given_Incorect_Id(){
        merchantRepository.createMerchant("42432","sadsads",1000);
        merchantRepository.deleteMerchantById("34254343");
        assertEquals(1, merchantRepository.getAllMerchant().size());
    }

}