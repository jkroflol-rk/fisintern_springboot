package com.example.fisintern_spring.dtos;

import com.example.fisintern_spring.entities.Timekeeping;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Timekeeping}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimekeepingDto implements Serializable {
    private Integer id;
    private Integer employee;
    private LocalDateTime timeStart = LocalDateTime.now();
    private LocalDateTime timeEnd;
    private Float totalTime;
    private Timekeeping.Status status = Timekeeping.Status.pending;
}