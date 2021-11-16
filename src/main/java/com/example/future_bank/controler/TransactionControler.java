package com.example.future_bank.controler;

import com.example.future_bank.entity.Transaction;
import com.example.future_bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class TransactionControler {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction){
        transaction.setDate(new Timestamp(System.currentTimeMillis()));
        return transactionService.createTransaction(transaction);
    }
}
