package com.example.future_bank.service;

import com.example.future_bank.entity.Account;
import com.example.future_bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceDblmpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    @Override
    public Account getAccountById(String id) {
        return accountRepository.getAccountById(id);
    }

    @Transactional
    @Override
    public Account registerAccount(Account account) {
        Boolean existAccount = validation(account);
        if (!existAccount){
        account.setPassword(passwordEncoder.encode((account.getPassword())));
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
        );}else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"your data isn't exist");
        }
        return account;
    }


    @Transactional
    @Override
    public void deleteAccount(String id) {
        Boolean existAccount = validation(accountRepository.getAccountById(id));
        if (!existAccount){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"your data isn't exist");
        }else {
            accountRepository.deleteAccountById(id);
        }
    }

    @Transactional
    @Override
    public void updateAccount(Account account) {
        Boolean existAccount = validation(account);
        if (existAccount){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"your data isn't exist");
        }else {
            accountRepository.updateAccount(account.getId(), account.getFullName(), account.getEmail(), account.getPhoneNumber(), account.getAddress(), account.getMotherName(), account.getNoAccount(), account.getPassword(), account.getUserName());
        }
    }

    private Boolean validation(Account account) {
        Boolean existAccount = getAllAccount().stream()
                        .anyMatch(e -> e.equals(account));
        return existAccount;
    }

    public void showById(String id){
        accountRepository.getAccountById(id);
    }
}
