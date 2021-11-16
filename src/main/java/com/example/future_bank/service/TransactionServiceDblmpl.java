package com.example.future_bank.service;

import com.example.future_bank.entity.Transaction;
import com.example.future_bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceDblmpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    @Override
    public Transaction createTransaction(Transaction transaction) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        transaction.setId(uuid);
        transactionRepository.createTransaction(
                transaction.getId(),
                transaction.getCategory(),
                transaction.getDate(),
                transaction.getNominal(),
                transaction.getWalletId()
        );
        return transaction;
    }

    @Transactional
    @Override
    public List<Transaction> createMultipleTransactions(List<Transaction> transactions) {
        return null;
    }


    @Transactional
    @Override
    public void updatedTransaction(Transaction transaction) {
        transactionRepository.updateTransaction( transaction.getId(),
                transaction.getCategory(),
                transaction.getDate(),
                transaction.getNominal(),
                transaction.getWalletId());
    }

    @Transactional
    @Override
    public void deleteTransaction(String id) {
        transactionRepository.deleteTransactionById(id);
    }

    @Transactional
    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.getAllTransaction();
    }
}
