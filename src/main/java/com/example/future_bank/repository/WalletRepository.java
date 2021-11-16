package com.example.future_bank.repository;

import com.example.future_bank.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

    @Query(value = "SELECT * FROM user_wallet WHERE id = ?1", nativeQuery = true)
    public Wallet getWalletById(String id);

    @Query(value = "select * from user_wallet", nativeQuery = true)
    public List<Wallet> getAllWallet();

    @Modifying
    @Query(value = "insert into user_wallet (id, saldo, acount_id) values (:id, :saldo, :account)", nativeQuery = true)
    public void createWallet(@Param("id") String id,
                             @Param("saldo") Integer saldo,
                             @Param("account")String account);

    @Modifying
    @Query(value = "delete from user_wallet where id=:id", nativeQuery = true)
    public void deleteWalletById(@Param("id") String id);

    @Modifying
    @Query(value = "update user_wallet set saldo = :saldo, acount_id = :account where id = :id", nativeQuery = true)
    public void updateWallet(@Param("id") String id,
                             @Param("saldo") Integer saldo,
                             @Param("account") String account);

    @Modifying
    @Query(value = "update user_wallet set saldo = :saldo where id = :id", nativeQuery = true)
    public void transactionCategory(
            @Param("id") String id,
            @Param("saldo") Integer saldo);
}
