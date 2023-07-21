package com.example.warehouse.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "code", unique = true, nullable = false)
    private UUID code=UUID.randomUUID();

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

}