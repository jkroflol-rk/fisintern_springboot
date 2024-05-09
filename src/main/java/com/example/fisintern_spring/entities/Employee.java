package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private Gender sex;

    @Column(name = "citizen_id", nullable = false, length = 12)
    private String citizenId;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "enrolment_date", nullable = false)
    private LocalDate enrolmentDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id")
    @Column(name = "role_id")
    private Integer role;

    @Column(name = "years_worked")
    private Integer yearsWorked;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private Integer user;

}