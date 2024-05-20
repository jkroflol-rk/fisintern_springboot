package com.example.fisintern_spring.dtos;

import com.example.fisintern_spring.entities.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Employee}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDto implements Serializable {
    private Integer id;
    private String name;
    private String phone;
    private LocalDate dob;
    private Gender sex;
    private String citizenId;
    private String address;
    private LocalDate enrolmentDate;
    private Integer role;
    private Integer yearsWorked;
    private Integer user;
}