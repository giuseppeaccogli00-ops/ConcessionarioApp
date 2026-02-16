package com.example.batch.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VenditaRow {

    private Integer idVenditore;
    private Integer prezzo;
    private Integer idCliente;
    private LocalDate data;
}

