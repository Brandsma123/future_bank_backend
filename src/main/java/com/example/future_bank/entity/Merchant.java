package com.example.future_bank.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_merchant")
public class Merchant {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
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
