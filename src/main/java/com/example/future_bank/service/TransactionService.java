package com.example.future_bank.service;

import com.example.future_bank.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction createTransaction(Transaction transaction);
    public List<Transaction> createMultipleTransactions(List<Transaction> transactions);
}
