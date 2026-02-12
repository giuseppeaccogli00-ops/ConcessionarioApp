package com.example.authservice.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_generator")
    @SequenceGenerator(
            name="role_generator",
            sequenceName = "role_sequence_name",
            allocationSize = 1
    )
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;


}
