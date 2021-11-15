package com.example.future_bank.repository;

import com.example.future_bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    public boolean existsByNoAccount(String noAccount);
    public boolean existsByUserName(String userName);
    public Optional<Account> findAccountByUserName(String username);

    @Query(value = "select * from user_account", nativeQuery = true)
    public List<Account> getAllAccount();

    @Modifying
    @Query(value = "insert into user_account (id, fullName, email, phoneNumber, address, motherName, noAccount, password, userName) values (::id,:fullName, :email, :phoneNumber, :address, :motherName, :noAccount, :password, :userName)", nativeQuery = true)
    public void RegisterAccount(@Param("id") String id,
                                @Param("fullName") String fullName,
                                @Param("email") String email,
                                @Param("phoneNumber") String phoneNumber,
                                @Param("address") String address,
                                @Param("motherName") String motherName,
                                @Param("noAccount") String noAccount,
                                @Param("password") String password,
                                @Param("userName") String userName);

    public Account getAccountById();
    
}
