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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cliente_generator")
    @SequenceGenerator(
            name="cliente_generator",
            sequenceName = "cliente_sequence_name",
            allocationSize = 1
    )
    private Integer idCliente;
    private String nome;
    private String cognome;
    private String dataNascita;


}
