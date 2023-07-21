package com.example.warehouse.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "auth_token")
public class AuthToken {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "uuid2", type = UuidGenerator.class)
    public final UUID   id = null;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "expire_time", nullable = false)
    private LocalDateTime expireTime;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

}
//org.hibernate.id.UUIDGenerator