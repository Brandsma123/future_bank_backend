package com.example.future_bank.repository;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
//    public Wallet createWallet(Wallet wallet);
//    public void updatedWallet(Wallet wallet);
//    public Wallet getWalletById(String id);
}
