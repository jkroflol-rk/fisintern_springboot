package com.example.fisintern_spring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_types")
public class ProductType {
    @Id
    @Column(name = "product_type_id", nullable = false)
    private Integer id;

    @Column(name = "product_type_name", nullable = false, length = 50)
    private String productTypeName;

}