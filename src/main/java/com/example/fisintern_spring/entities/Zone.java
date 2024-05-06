package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zones")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id", nullable = false)
    private Integer id;

    @Column(name = "zone_name", nullable = false, length = 50)
    private String zoneName;

    @Column(name = "hourly_price", nullable = false, precision = 13, scale = 2)
    private BigDecimal hourlyPrice;

    @Column(name = "seats", nullable = false)
    private Integer seats;

}