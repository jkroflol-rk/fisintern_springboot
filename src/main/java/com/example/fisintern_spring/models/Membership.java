package com.example.fisintern_spring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @Column(name = "total_price_required")
    private Integer totalPriceRequired;

    @OneToMany(mappedBy = "membership")
    private Set<Customer> customers = new LinkedHashSet<>();

}