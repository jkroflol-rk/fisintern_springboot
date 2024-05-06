package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "billiard_tables")
public class BilliardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billiard_table_id", nullable = false)
    private Integer id;

    @Column(name = "btable_name", length = 50)
    private String btableName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "zone_id")
    @Column(name = "zone_id")
    private Integer zone;

    public enum Status { vacant, occupied }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.vacant;

    @Lob
    @Column(name = "notes")
    private String notes;

}