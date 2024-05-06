package com.example.fisintern_spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "memberships")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "membership")
    private Set<Customer> customers = new LinkedHashSet<>();

}