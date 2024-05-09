package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "timekeeping")
public class Timekeeping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timekeeping_id", nullable = false)
    private Integer id;

    @Column(name = "employee_id", nullable = false)
    private Integer employee;

    @Builder.Default
    @Column(name = "time_start", nullable = false)
    private LocalDateTime timeStart = LocalDateTime.now();

    @Column(name = "time_end")
    private LocalDateTime timeEnd;

    @Column(name = "total_time")
    private Float totalTime;

    public enum Status { pending, active, ended };

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public Status status = Status.pending;
}