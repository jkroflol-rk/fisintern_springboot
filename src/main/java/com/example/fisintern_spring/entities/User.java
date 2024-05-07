package com.example.fisintern_spring.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "access")
    private Access access;
}