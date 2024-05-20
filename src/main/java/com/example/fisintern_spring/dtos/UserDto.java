package com.example.fisintern_spring.dtos;

import com.example.fisintern_spring.entities.Access;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.fisintern_spring.entities.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Access access;
}