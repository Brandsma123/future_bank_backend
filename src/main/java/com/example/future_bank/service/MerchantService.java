package com.example.future_bank.service;

import com.example.future_bank.entity.Merchant;

import java.util.List;

public interface MerchantService {
    public Merchant createMerchant(Merchant merchant);
    public List<Merchant> getAllMerchant();
    public void deleteMerchant(String id);
    public Merchant updateMerchant(Merchant merchant);
}
