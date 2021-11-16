package com.example.future_bank.service;

import com.example.future_bank.dto.UserDetailmpl;
import com.example.future_bank.entity.Account;
import com.example.future_bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceDbimpl implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (!accountRepository.findAccountByUserName(userName).isPresent()){
            throw new UsernameNotFoundException("your account is not exist");
        }
        Account account=accountRepository.findAccountByUserName(userName).get();

        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails userDetails=new UserDetailmpl(account.getUserName(),account.getPassword(),authorities);
        return userDetails;
    }
}
