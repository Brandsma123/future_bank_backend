package com.example.future_bank.controler;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Merchant;
import com.example.future_bank.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MerchantControler {
    @Autowired
    MerchantService merchantService;

    @PostMapping("/merchant")
    public Merchant createMerchant(@RequestBody Merchant merchant){
        return merchantService.createMerchant(merchant);
    }

    @GetMapping("/allMerchant")
    public List<Merchant> getAllMerchant(){
        return merchantService.getAllMerchant();
    }
}
