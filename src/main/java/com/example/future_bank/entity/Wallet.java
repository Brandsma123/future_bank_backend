package com.example.future_bank.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_wallet")
public class Wallet {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
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

    public Wallet(Integer saldo, List<Transaction> transactions) {
        this.saldo = saldo;
        this.transactions = transactions;
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

}
