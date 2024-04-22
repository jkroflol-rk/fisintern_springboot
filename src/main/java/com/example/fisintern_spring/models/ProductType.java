package com.example.fisintern_spring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_types")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id", nullable = false)
    private Integer id;

    @Column(name = "product_type_name", nullable = false, length = 50)
    private String productTypeName;

    @OneToMany(mappedBy = "type")
    private Set<Product> products = new LinkedHashSet<>();

}