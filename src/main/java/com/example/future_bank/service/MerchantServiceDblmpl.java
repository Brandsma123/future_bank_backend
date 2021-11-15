package com.example.future_bank.service;

import com.example.future_bank.entity.Merchant;
import com.example.future_bank.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class MerchantServiceDblmpl implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;
    @Transactional
    @Override
    public Merchant createMerchant(Merchant merchant) {

        String uuid = UUID.randomUUID().toString().replace("-", "");
        merchant.setId(uuid);
        merchantRepository.createMerchant(
                merchant.getId(),
                merchant.getFullName(),
                merchant.getPrice()
        );
        return merchant;
    }


    @Transactional
    @Override
    public List<Merchant> getAllMerchant() {
        return merchantRepository.getAllMerchant();
    }

    @Transactional
    @Override
    public void deleteMerchant(String id) {
         merchantRepository.deleteMerchantById(id);
    }

    @Transactional
    @Override
    public Merchant updateMerchant(Merchant merchant) {
        merchantRepository.updateMerchant(merchant.getId(), merchant.getFullName(), merchant.getPrice());
        return merchant;
    }
}
