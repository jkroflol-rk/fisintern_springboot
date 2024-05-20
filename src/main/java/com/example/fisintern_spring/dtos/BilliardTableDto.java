package com.example.fisintern_spring.dtos;

import com.example.fisintern_spring.entities.BilliardTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.fisintern_spring.entities.BilliardTable}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BilliardTableDto implements Serializable {
    private Integer id;
    private String btableName;
    private Integer zone;
    private BilliardTable.Status status = BilliardTable.Status.vacant;
    private String notes;
}