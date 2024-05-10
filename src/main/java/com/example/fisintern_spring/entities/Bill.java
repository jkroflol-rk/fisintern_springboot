package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "employee_id")
    private Integer employee;

    @Builder.Default
    @Column(name = "time")
    private LocalDateTime time = LocalDateTime.now();
}