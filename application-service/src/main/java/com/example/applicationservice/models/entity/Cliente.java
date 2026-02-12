package com.example.applicationservice.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Integer idCliente;
    private String nome;
    private String cognome;
    private String dataNascita;


}
