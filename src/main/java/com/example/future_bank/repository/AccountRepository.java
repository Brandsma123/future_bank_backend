package com.example.future_bank.repository;

import com.example.future_bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    public boolean existsByNoAccount(String noAccount);
    public boolean existsByUserName(String userName);
    public Optional<Account> findAccountByUserName(String username);

    public List<Account> getAllAccount();
    public Account RegisterAccount(Account account);
    public Account getAccountById();
}
