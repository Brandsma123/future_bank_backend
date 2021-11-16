package com.example.future_bank.controler;

import com.example.future_bank.dto.UserCredentials;
import com.example.future_bank.entity.Account;
import com.example.future_bank.security.JwtTokenUtil;
import com.example.future_bank.service.AccountService;
import com.example.future_bank.service.AccountServiceDblmpl;
import com.example.future_bank.service.UserDetailsServiceDbimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountControler {

    @Autowired
    AccountServiceDblmpl accountServiceDblmpl;
    @Autowired
    AccountService accountService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsServiceDbimpl userDetailsServiceDbimpl;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
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
    public void updateAccount(@RequestBody Account account){
        accountService.updateAccount(account);
    }

    @PostMapping("/signin")
    public Map<String, Object> signin(@RequestBody UserCredentials userCredentials){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                new UsernamePasswordAuthenticationToken(userCredentials.getUserName(),userCredentials.getPassword());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetails userDetails=userDetailsServiceDbimpl.loadUserByUsername(userCredentials.getUserName());
        String token=jwtTokenUtil.generateToken(userDetails);
        Map<String, Object> tokenWrapper=new HashMap<>();
        tokenWrapper.put("token", token);
        return tokenWrapper;
    }
}
