package com.example.future_bank.service;

import com.example.future_bank.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceDblmpl implements TransactionService{
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> createMultipleTransactions(List<Transaction> transactions) {
        return null;
    }
}
