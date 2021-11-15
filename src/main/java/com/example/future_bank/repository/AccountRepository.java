package com.example.future_bank.repository;

import com.example.future_bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
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
    @Query(value = "insert into user_account (id, full_name, email, phone_number, address, mother_name, no_account, password, user_name) values (:id,:fullName, :email, :phoneNumber, :address, :motherName, :noAccount, :password, :userName)", nativeQuery = true)
    public void RegisterAccount(@Param("id") String id,
                                @Param("fullName") String fullName,
                                @Param("email") String email,
                                @Param("phoneNumber") String phoneNumber,
                                @Param("address") String address,
                                @Param("motherName") String motherName,
                                @Param("noAccount") String noAccount,
                                @Param("password") String password,
                                @Param("userName") String userName);

    @Query(value = "SELECT * FROM user_account ORDER BY id", countQuery = "SELECT count(*) FROM user_account", nativeQuery = true)
    public Account getAccountById(String id);

    @Modifying
    @Query(value = "delete from user_account where id=:id", nativeQuery = true)
    public void deleteAccountById(@Param("id") String id);

    @Modifying
    @Query(value = "update user_account set full_name = :fullName, emeil = :email, phone_number = :phoneNumber, address = :address, mother_name = :motherName, no_account = :noAccount, password = :password, user_name = :userName) values (:id,:fullName, :email, :phoneNumber, :address, :motherName, :noAccount, :password, :userName where id = :id", nativeQuery = true)
    public void updateAccount(@Param("id") String id,
                                @Param("fullName") String fullName,
                                @Param("email") String email,
                                @Param("phoneNumber") String phoneNumber,
                                @Param("address") String address,
                                @Param("motherName") String motherName,
                                @Param("noAccount") String noAccount,
                                @Param("password") String password,
                                @Param("userName") String userName);

}
