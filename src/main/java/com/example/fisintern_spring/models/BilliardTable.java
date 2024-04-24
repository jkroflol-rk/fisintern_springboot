package com.example.fisintern_spring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ColumnDefault("vacant")
    @Lob
    @Column(name = "status")
    private String status;

    @Lob
    @Column(name = "notes")
    private String notes;

}