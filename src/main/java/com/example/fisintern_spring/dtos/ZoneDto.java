package com.example.fisintern_spring.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Zone}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZoneDto implements Serializable {
    private Integer id;
    private String zoneName;
    private BigDecimal hourlyPrice;
    private Integer seats;
}