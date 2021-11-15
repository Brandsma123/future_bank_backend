package com.example.future_bank.service;

import com.example.future_bank.entity.Account;
import com.example.future_bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceDblmpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    @Transactional
    @Override
    public Account registerAccount(Account account) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        account.setId(uuid);
        accountRepository.RegisterAccount(
                account.getId(),
                account.getFullName(),
                account.getEmail(),
                account.getPhoneNumber(),
                account.getAddress(),
                account.getMotherName(),
                account.getNoAccount(),
                account.getPassword(),
                account.getUserName()
        );
        return account;
    }


    @Override
    public void deleteAccount(String id) {
         accountRepository.deleteAccountById(id);
    }

    @Override
    public Account updateAccount(Account account) {
        accountRepository.updateAccount(account.getId(), account.getFullName(), account.getEmail(), account.getPhoneNumber(), account.getAddress(), account.getMotherName(), account.getNoAccount(), account.getPassword(), account.getUserName());
        return account;
    }


}
