package com.example.future_bank.dto;

import java.util.Objects;

public class TransactionCategory {
    String category;
    Integer nominal;
    String walletId;
    String merchantId;

    public TransactionCategory(String category, Integer nominal, String walletId, String merchantId) {
        this.category = category;
        this.nominal = nominal;
        this.walletId = walletId;
        this.merchantId = merchantId;
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

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionCategory that = (TransactionCategory) o;
        return Objects.equals(category, that.category) && Objects.equals(nominal, that.nominal) && Objects.equals(walletId, that.walletId) && Objects.equals(merchantId, that.merchantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, nominal, walletId, merchantId);
    }
}
