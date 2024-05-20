package com.example.fisintern_spring.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.example.fisintern_spring.entities.ImportInvoice}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportInvoiceDto implements Serializable {
    private Integer id;
    private Integer product;
    private Integer employee;
    private Integer supplier;
    private Instant time;
    private BigDecimal totalPrice;
}