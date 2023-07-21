package com.example.warehouse.entity;

import lombok.*;

import javax.persistence.*;

@Entity (name = "attachment_content")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bytes", nullable = false)
    private byte[] bytes;

    @OneToOne()
    @JoinColumn(name = "attachment_id", nullable = false)
    private Attachment attachment;

}
