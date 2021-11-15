package com.example.future_bank.controler;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Merchant;
import com.example.future_bank.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MerchantControler {
    @Autowired
    MerchantService merchantService;

    @PostMapping("/merchant")
    public Merchant createMerchant(@RequestBody Merchant merchant){
        return merchantService.createMerchant(merchant);
    }

    @GetMapping("/merchants")
    public List<Merchant> getAllMerchant(){
        return merchantService.getAllMerchant();
    }

    @DeleteMapping("/merchant")
    public void deleteMerchantById(@RequestParam(name = "id") String id){
        merchantService.deleteMerchant(id);
    }

    @PutMapping("merchant")
    public Merchant updateMerchant(@RequestBody Merchant merchant){
        return merchantService.updateMerchant(merchant);
    }
}
