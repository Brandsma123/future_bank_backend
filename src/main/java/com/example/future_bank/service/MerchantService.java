package com.example.future_bank.service;

import com.example.future_bank.entity.Merchant;

public interface MerchantService {
    public Merchant createMerchant(Merchant merchant);
    public Merchant getMerchantById(String id);
}
