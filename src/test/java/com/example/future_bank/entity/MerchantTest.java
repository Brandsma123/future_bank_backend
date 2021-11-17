package com.example.future_bank.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MerchantTest {

    @Test
    public void able_To_Create_Merchant(){
        Merchant merchant = new Merchant("Laptop",1000);
        assertNotNull(merchant);
    }

    @Test
    public void able_To_Create_Merchant_with_given_information(){
        Merchant merchant1 = new Merchant("Laptop",1000);
        Merchant merchant2 = new Merchant("Laptop",1000);
        assertEquals(merchant1, merchant2);
    }

    @Test
    public void should_Return_False_When_Account_Given_False_Information(){
        Merchant merchant1 = new Merchant("Laptop",1000);
        Merchant merchant2 = new Merchant("Hp",2000);
        assertNotEquals(merchant1, merchant2);
    }

}