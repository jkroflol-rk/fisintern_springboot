package com.example.fisintern_spring.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Supplier}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierDto implements Serializable {
    private Integer id;
    private String supplierName;
    private String phone;
    private String email;
    private String address;
    private BigDecimal totalDebt;
    private BigDecimal totalPaid;
    private String taxNum;
    private String notes;
}