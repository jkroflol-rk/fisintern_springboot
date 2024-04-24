package com.example.fisintern_spring.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", length = 10)
    private String phone;

    public enum Gender{ M, F }

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Gender sex;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "debt", precision = 13, scale = 2)
    private BigDecimal debt;

    @Column(name = "total", precision = 13, scale = 2)
    private BigDecimal total;

//    @JsonManagedReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "membership_id")
    @Column(name = "membership_id")
    private Integer membership;

    @Column(name = "company")
    private String company;

    Customer(){}

    //write a constructor that takes in all the fields except id
    public Customer(String name, String phone, Gender sex, String email, BigDecimal debt, BigDecimal total, Integer membership, String company) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.debt = debt;
        this.total = total;
        this.membership = membership;
        this.company = company;
        this.sex = sex;
    }
}