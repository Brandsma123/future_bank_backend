package com.example.future_bank.service;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Merchant;
import com.example.future_bank.entity.Transaction;
import com.example.future_bank.entity.Wallet;
import com.example.future_bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceDblmpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletService walletService;
    @Autowired
    MerchantService merchantService;
    @Autowired
    AccountService accountService;

    @Transactional
    @Override
    public Transaction createTransaction(Transaction transaction) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        transaction.setId(uuid);
        Wallet wallet = walletService.getWalletById(transaction.getWalletId());
        if (transaction.getCategory().equalsIgnoreCase("Withdraw")){
            if (wallet.getSaldo() < transaction.getNominal()){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "your saldo is not enough");
            }
            wallet.withDrawTransaction(transaction.getNominal());
            walletService.transactionCategory(wallet);
        }else if (transaction.getCategory().equalsIgnoreCase("Top Up")){
            wallet.topUpTransaction(transaction.getNominal());
            walletService.transactionCategory(wallet);
        }else if (transaction.getCategory().equalsIgnoreCase("Payment")){
            Merchant merchant = merchantService.getMerchantById(transaction.getMerchantId());
            if (wallet.getSaldo() < merchant.getPrice()){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN,"your saldo not enough");
            }
            transaction.setNominal(merchant.getPrice());
            wallet.paymentTransaction(merchant.getPrice());
            walletService.transactionCategory(wallet);
        }
        transaction.setWallet(wallet    );
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
        for (Transaction transaction:transactions) {
            createTransaction(transaction);
        }
        return transactions;
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
