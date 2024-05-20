package com.example.fisintern_spring.dtos;

import com.example.fisintern_spring.entities.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Customer}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto implements Serializable {
    private Integer id;
    private String name;
    private String phone;
    private Gender sex;
    private LocalDate dob;
    private String address;
    private String email;
    private BigDecimal debt = BigDecimal.valueOf(0);
    private BigDecimal total = BigDecimal.valueOf(0);
    private Integer membership;
    private String company;
}