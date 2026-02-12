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
public class Vendita {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendita_generator")
    @SequenceGenerator(
            name = "vendita_generator",
            sequenceName = "vendita_sequence",
            allocationSize = 1
    )
    private Integer idVendita;


    private String data;
    private Integer idVenditore;

    @ManyToOne
    @JoinColumn(name="ID_AUTO")
    private Auto auto;

    @ManyToOne
    @JoinColumn(name="ID_CLIENTE")
    private Cliente cliente;

}
