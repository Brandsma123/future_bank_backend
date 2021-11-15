package com.example.future_bank.controler;

import com.example.future_bank.entity.Account;
import com.example.future_bank.service.AccountService;
import com.example.future_bank.service.AccountServiceDblmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountControler {

    @Autowired
    AccountServiceDblmpl accountServiceDblmpl;
    @Autowired
    AccountService accountService;

    @PostMapping("register")
    public void createAccount(@RequestBody Account account){
        accountService.registerAccount(account);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    @DeleteMapping("/account")
    public void deleteAccountById(@RequestParam(name = "id") String id){
        accountService.deleteAccount(id);
    }

    @PutMapping("/account")
    public Account updateAccount(@RequestBody Account account){
       return accountService.updateAccount(account);
    }
}
