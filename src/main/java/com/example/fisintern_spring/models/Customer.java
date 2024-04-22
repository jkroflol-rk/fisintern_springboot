package com.example.fisintern_spring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @OneToMany(mappedBy = "customer")
    private Set<Bill> bills = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    public enum Gender { M, F }
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Gender gender;

    @Column(name = "dob")
    private String dob;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "debt")
    private Double debt;

    @Column(name = "total")
    private Double total;

    @Column(name = "membership_id")
    private Integer membership_id;
}
