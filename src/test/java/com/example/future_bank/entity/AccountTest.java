package com.example.future_bank.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void able_To_Create_Account(){
    Account account = new Account("Brandsma","brandsma@Gmail", "43223432","Jakarta","susi","6886", "brandsma","brandsma");
    assertNotNull(account);
    }

    @Test
    public void able_To_Create_Account_with_given_information(){
        Account account1 = new Account("Brandsma","brandsma@Gmail", "43223432","Jakarta","susi","6886", "brandsma","brandsma");
        Account account2 = new Account("Brandsma","brandsma@Gmail", "43223432","Jakarta","susi","6886", "brandsma","brandsma");
    assertEquals(account1,account2);
    }

    @Test
    public void should_Return_False_When_Account_Given_False_Information(){
        Account account1 = new Account("Brandsma","brandsma@Gmail", "43223432","Jakarta","susi","6886", "brandsma","brandsma");
        Account account2 = new Account("Brasdsma","brandsasma@Gmail", "4322343432","Jakardsta","suasdsi","sa688sad6", "brsadandsmsda","brasdandssdma");
        assertNotEquals(account1,account2);
    }
}
