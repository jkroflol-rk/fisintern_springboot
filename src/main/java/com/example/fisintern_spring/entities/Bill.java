package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id", nullable = false)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer;

    @Column(name = "total_price", precision = 13, scale = 2)
    private BigDecimal totalPrice;

    @Lob
    @Column(name = "status")
    private String status;

}