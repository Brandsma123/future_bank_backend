package com.example.future_bank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "user_transaction")
public class Transaction {

    @Id
    private String id;

    @Column(nullable = false, length = 45)
    private String category;

    @Column(nullable = false)
    private Integer nominal;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp date;

    @Transient
    private String merchantId;

    @Transient
    private String walletId;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    Wallet wallet;

    public Transaction() {
    }

    public Transaction(String category, Integer nominal, Timestamp date) {

        this.category = category;
        this.nominal = nominal;
        this.date = date;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @JsonIgnore
    public Wallet getWallet() {
        return wallet;
    }
}
