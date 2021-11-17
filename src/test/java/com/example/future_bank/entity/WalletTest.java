package com.example.future_bank.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    public void able_To_Create_Wallet(){
        Wallet wallet = new Wallet(1000000,"T87686");
        assertNotNull(wallet);
    }

    @Test
    public void able_To_Create_Wallet_with_given_information(){
        Wallet wallet1 = new Wallet(1000000,"T87686");
        Wallet wallet2 = new Wallet(1000000,"T87686");
        assertEquals(wallet1, wallet2);
    }

    @Test
    public void should_Return_False_When_Wallet_Given_False_Information(){
        Wallet wallet1 = new Wallet(1000000,"T87686");
        Wallet wallet2 = new Wallet(100000,"T8786");
        assertNotEquals(wallet1, wallet2);
    }


}