package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id", nullable = false)
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "billard_table_id", nullable = false)
    @Column(name = "billiard_table_id", nullable = false)
    private Integer btableId;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "customer_id", nullable = false)
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id")
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "reserve_time")
    private LocalDateTime reserveTime = LocalDateTime.now();

    public enum Status { unpaid, paid }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.unpaid;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "total_time", precision = 9, scale = 2)
    private BigDecimal totalTime;

    @Column(name = "total_price", precision = 13, scale = 2)
    private BigDecimal totalPrice;

    @Lob
    @Column(name = "notes")
    private String notes;
}
