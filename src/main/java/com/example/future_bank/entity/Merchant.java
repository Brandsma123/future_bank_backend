package com.example.future_bank.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_merchant")
public class Merchant {

    @Id
    private String id;

    @Column(nullable = false, length = 45, name = "full_name")
    private String fullName;

    @Column(nullable = false)
    private Integer price;

    public Merchant() {
    }

    public Merchant(String fullName, Integer price) {
        this.fullName = fullName;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getPrice() {
        return price;
    }
}
