package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detail_bills")
public class DetailBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id", nullable = false)
    private Integer id;

    @Column(name = "product_id")
    private Integer product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "reserve_id")
    private Integer reserve;

    @Column(name = "total_price", precision = 13, scale = 2)
    private BigDecimal totalPrice;

}