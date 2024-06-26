package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "supplier_id")
    @Column(name = "supplier_id")
    private Integer supplier;

    @Column(name = "product_name", length = 50)
    private String productName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "type_id")
    @Column(name = "type_id")
    private Integer type;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "import_price", precision = 13, scale = 2)
    private BigDecimal importPrice;

    @Column(name = "discount", precision = 13, scale = 2)
    private BigDecimal discount;

    @Column(name = "final_price", precision = 13, scale = 2)
    private BigDecimal finalPrice;

    @Column(name = "selling_price", precision = 13, scale = 2)
    private BigDecimal sellingPrice;

    @Column(name = "available")
    private Integer available;

    @Column(name = "sold")
    private Integer sold;

    @Column(name = "total_sold", precision = 13, scale = 2)
    private BigDecimal totalSold;

}