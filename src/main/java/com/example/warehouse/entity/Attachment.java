package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "size",nullable = false)
    private Long size;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "content_type", nullable = false)
    private String content_type;

}
