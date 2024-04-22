package com.example.fisintern_spring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "product_name", length = 50)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private ProductType type;

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

    @OneToMany(mappedBy = "product")
    private Set<DetailBill> detailBills = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<ImportInvoice> importInvoices = new LinkedHashSet<>();

}