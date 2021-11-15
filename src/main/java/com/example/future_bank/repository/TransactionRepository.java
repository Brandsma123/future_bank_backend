package com.example.future_bank.repository;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    public Transaction createTransaction(Transaction transaction);
    public List<Transaction> createMultipleTransactions(List<Transaction> transactions);
}
