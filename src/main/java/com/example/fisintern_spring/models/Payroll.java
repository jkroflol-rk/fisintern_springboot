package com.example.fisintern_spring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payrolls")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payroll_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "allowance", precision = 13, scale = 2)
    private BigDecimal allowance;

    @Column(name = "bonus", precision = 13, scale = 2)
    private BigDecimal bonus;

    @Column(name = "deduction", precision = 13, scale = 2)
    private BigDecimal deduction;

    @Column(name = "final", precision = 13, scale = 2)
    private BigDecimal finalField;

}