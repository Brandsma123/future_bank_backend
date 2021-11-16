package com.example.future_bank.service;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Wallet;
import com.example.future_bank.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class WalletServiceDblmpl implements WalletService{

    @Autowired
    WalletRepository walletRepository;

    @Transactional
    @Override
    public Wallet createWallet(Wallet wallet) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        wallet.setId(uuid);
        walletRepository.createWallet(
                wallet.getId(),
                wallet.getSaldo(),
                wallet.getAccountId()
        );
          return wallet;
    }

    @Transactional
    @Override
    public void updatedWallet(Wallet wallet) {
        walletRepository.updateWallet(wallet.getId(), wallet.getSaldo(), wallet.getAccountId());
    }

    @Transactional
    @Override
    public void deleteWallet(String id) {
        walletRepository.deleteWalletById(id);
    }

    @Transactional
    @Override
    public List<Wallet> getAllWallet() {
        return walletRepository.getAllWallet();
    }

    @Override
    public Wallet getWalletById(String id) {
        return walletRepository.getWalletById(id);
    }

    @Override
    public void transactionCategory(Wallet wallet) {
        walletRepository.transactionCategory(wallet.getId(), wallet.getSaldo());
    }


}
