package com.example.future_bank.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_wallet")
public class Wallet {

    @Id
    private String id;
    private Integer saldo;

    @Transient
    private String accountId;

    @ManyToOne
    @JoinColumn(name = "acount_id")
    private Account account;

    @OneToMany(mappedBy = "wallet")
    private List<Transaction> transactions;

    public Wallet() {
    }

//    public Wallet(Integer saldo, List<Transaction> transactions) {
//        this.saldo = saldo;
//        this.transactions = transactions;
//    }

    public Wallet(Integer saldo, String accountId) {
        this.saldo = saldo;
        this.accountId = accountId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void withDrawTransaction (Integer withdraw){this.saldo -= withdraw;}

    public void topUpTransaction (Integer topUp){this.saldo += topUp;}

    public void paymentTransaction (Integer payment){this.saldo -= payment;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(saldo, wallet.saldo) && Objects.equals(accountId, wallet.accountId) && Objects.equals(account, wallet.account) && Objects.equals(transactions, wallet.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, saldo, accountId, account, transactions);
    }
}
