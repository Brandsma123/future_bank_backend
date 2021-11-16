package com.example.future_bank.service;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Wallet;

import java.util.List;

public interface WalletService {

    public Wallet createWallet(Wallet wallet);
    public void updatedWallet(Wallet wallet);
    public void deleteWallet(String id);
    public List<Wallet> getAllWallet(Wallet wallet);
}
