package com.example.future_bank.repository;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, String> {

    public Merchant createMerchant(Merchant merchant);
    public Merchant getMerchantById(String id);
}
