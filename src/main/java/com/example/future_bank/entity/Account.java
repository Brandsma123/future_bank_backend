package com.example.future_bank.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_account")
public class Account {

    @Id
    private String id;

    @Column(nullable = false, length = 45, name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, unique = true, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 45, name = "mother_name")
    private String motherName;

    @Column(nullable = false, unique = true, length = 45, name = "no_account")
    private String noAccount;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, unique = true, length = 45)
    private String userName;


    @OneToMany(mappedBy = "account")
    private List<Wallet> wallets;

    public Account() {
    }

    public Account(String fullName, String email, String phoneNumber, String address, String motherName, String noAccount, String password, String userName) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.motherName = motherName;
        this.noAccount = noAccount;
        this.password = password;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getNoAccount() {
        return noAccount;
    }

    public void setNoAccount(String noAccount) {
        this.noAccount = noAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(fullName, account.fullName) && Objects.equals(email, account.email) && Objects.equals(phoneNumber, account.phoneNumber) && Objects.equals(address, account.address) && Objects.equals(motherName, account.motherName) && Objects.equals(noAccount, account.noAccount) && Objects.equals(password, account.password) && Objects.equals(userName, account.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, phoneNumber, address, motherName, noAccount, password, userName);
    }
}




