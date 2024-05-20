package com.example.fisintern_spring.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Bill}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillDto implements Serializable {
    private Integer id;
    private Integer customer;
    private BigDecimal totalPrice;
    private String status;
    private Integer employee;
    private LocalDateTime time = LocalDateTime.now();
}