package com.example.fisintern_spring.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Membership}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipDto implements Serializable {
    private Integer id;
    private String name;
    private Integer discountPercent;
    private Integer totalPriceRequired;
    private Set<CustomerDto> customers = new LinkedHashSet<>();
}