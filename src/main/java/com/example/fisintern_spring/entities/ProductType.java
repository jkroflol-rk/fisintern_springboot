package com.example.fisintern_spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_types")
public class ProductType {
    @Id
    @Column(name = "product_type_id", nullable = false)
    private Integer id;

    @Column(name = "product_type_name", nullable = false, length = 50)
    private String productTypeName;

}