package com.example.fisintern_spring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
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

    @Lob
    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "citizen_id", nullable = false, length = 12)
    private String citizenId;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "enrolment_date", nullable = false)
    private LocalDate enrolmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "years_worked")
    private Integer yearsWorked;

    @OneToMany(mappedBy = "employee")
    private Set<ImportInvoice> importInvoices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Payroll> payrolls = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Reservation> reservations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Timekeeping> timekeepings = new LinkedHashSet<>();

}