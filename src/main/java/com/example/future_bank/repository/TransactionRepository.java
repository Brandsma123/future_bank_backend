package com.example.future_bank.repository;

import com.example.future_bank.entity.Account;
import com.example.future_bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value = "select * from user_transaction", nativeQuery = true)
    public List<Transaction> getAllTransaction();

    @Modifying
    @Query(value = "insert into user_transaction (id, category, date, nominal, wallet_id) values (:id, :category, :date, :nominal, :wallet)", nativeQuery = true)
    public void createTransaction(@Param("id") String id,
                                  @Param("category") String category,
                                  @Param("date")Date date,
                                  @Param("nominal") Integer nominal,
                                  @Param("wallet") String wallet);

    @Modifying
    @Query(value = "delete from user_transaction where id=:id", nativeQuery = true)
    public void deleteTransactionById(@Param("id") String id);

    @Modifying
    @Query(value = "update user_transaction set category = :category, date = :date, nominal = :nominal, wallet_id = :wallet where id = :id", nativeQuery = true)
    public void updateTransaction(@Param("id") String id,
                             @Param("category") String category,
                             @Param("date")Date date,
                             @Param("nominal") Integer nominal,
                             @Param("wallet") String wallet);
}
