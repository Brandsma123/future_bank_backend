package com.example.future_bank.controler;

import com.example.future_bank.entity.Wallet;
import com.example.future_bank.service.WalletService;
import com.example.future_bank.service.WalletServiceDblmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WalletControler {

    @Autowired
    WalletService walletService;

    @PostMapping("/wallet")
    public Wallet createAccount(@RequestBody Wallet wallet){
        return walletService.createWallet(wallet);
    }

    @GetMapping("/wallets")
    public List<Wallet> getAllWallet(){
        return walletService.getAllWallet();
    }
}
