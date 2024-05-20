package com.example.fisintern_spring.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements Serializable {
    private Integer id;
    private Integer supplier;
    private String productName;
    private Integer type;
    private String description;
    private Integer quantity;
    private BigDecimal importPrice;
    private BigDecimal discount;
    private BigDecimal finalPrice;
    private BigDecimal sellingPrice;
    private Integer available;
    private Integer sold;
    private BigDecimal totalSold;
}