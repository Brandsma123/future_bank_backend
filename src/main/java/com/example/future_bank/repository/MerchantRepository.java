package com.example.future_bank.repository;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String> {

    @Query(value = "select * from user_merchant", nativeQuery = true)
    public List<Merchant> getAllMerchant();

    @Modifying
    @Query(value = "INSERT INTO user_merchant (id, full_name, price) VALUES (:id, :fullName, :price)", nativeQuery = true)
    public void createMerchant(@Param("id") String id,
                               @Param("fullName") String fullName,
                               @Param("price") Integer price);

//    public Merchant getMerchantById(String id);
}
