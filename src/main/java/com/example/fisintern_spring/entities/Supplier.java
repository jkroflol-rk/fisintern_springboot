package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", nullable = false)
    private Integer id;

    @Column(name = "supplier_name", length = 50)
    private String supplierName;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "total_debt", precision = 13, scale = 2)
    private BigDecimal totalDebt;

    @Column(name = "total_paid", precision = 13, scale = 2)
    private BigDecimal totalPaid;

    @Column(name = "tax_num", length = 50)
    private String taxNum;

    @Lob
    @Column(name = "notes")
    private String notes;
}