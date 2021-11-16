package com.example.future_bank.service;

import com.example.future_bank.entity.Merchant;
import com.example.future_bank.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class MerchantServiceDblmpl implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;
    @Transactional
    @Override
    public Merchant createMerchant(Merchant merchant) {
        Boolean existMerchant = validationMerchant(merchant);
        if (!existMerchant){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        merchant.setId(uuid);
        merchantRepository.createMerchant(
                merchant.getId(),
                merchant.getFullName(),
                merchant.getPrice()
        );}else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"your data isn't exist");
        }
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
        Boolean existMerchant = validationMerchant(merchantRepository.getMerchantById(id));
        if (!existMerchant){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"your data isn't exist");
        }else {
            merchantRepository.deleteMerchantById(id);
        }
    }

    @Transactional
    @Override
    public Merchant updateMerchant(Merchant merchant) {
        Boolean existMerchant = validationMerchant(merchant);
        if (existMerchant){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"your data isn't exist");
        }else {
            merchantRepository.updateMerchant(merchant.getId(), merchant.getFullName(), merchant.getPrice());
            return merchant;
        }
    }

    private Boolean validationMerchant(Merchant merchant) {
        Boolean existMerchant = getAllMerchant().stream().anyMatch(e -> e.equals(merchant));
        return existMerchant;
    }

    @Override
    public Merchant getMerchantById(String id) {
        return merchantRepository.getMerchantById(id);
    }
}
