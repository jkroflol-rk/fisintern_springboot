package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "import_invoices")
public class ImportInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "import_id", nullable = false)
    private Integer id;

    @Column(name = "product_id")
    private Integer product;

    @Column(name = "employee_id")
    private Integer employee;

    @Column(name = "supplier_id")
    private Integer supplier;

    @Column(name = "time")
    private Instant time;

    @Column(name = "total_price", precision = 13, scale = 2)
    private BigDecimal totalPrice;

}