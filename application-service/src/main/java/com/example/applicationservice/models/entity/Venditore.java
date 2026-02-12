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
public class Venditore {

    @Id
    private Integer idVenditore;
    private String nome;
    private String cognome;
    private String dataNascita;
}
