package com.example.fisintern_spring.dtos;

import com.example.fisintern_spring.entities.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.fisintern_spring.entities.Reservation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationDto implements Serializable {
    private Integer id;
    private Integer btableId;
    private Integer customerId;
    private Integer employeeId;
    private LocalDateTime reserveTime = LocalDateTime.now();
    private Reservation.Status status = Reservation.Status.unpaid;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal totalTime;
    private BigDecimal totalPrice;
    private String notes;
}