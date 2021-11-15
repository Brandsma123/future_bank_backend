package com.example.future_bank.service;

import com.example.future_bank.entity.Wallet;

public interface WalletService {

    public Wallet createWallet(Wallet wallet);
    public void updatedWallet(Wallet wallet);
    public Wallet getWalletById(String id);
}
