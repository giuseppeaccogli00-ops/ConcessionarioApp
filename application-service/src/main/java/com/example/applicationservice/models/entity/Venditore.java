package com.example.applicationservice.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Venditore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "venditore_generator")
    @SequenceGenerator(
            name="venditore_generator",
            sequenceName = "venditore_sequence_name",
            allocationSize = 1
    )
    private Integer idVenditore;
    private String nome;
    private String cognome;
    private String dataNascita;
}
