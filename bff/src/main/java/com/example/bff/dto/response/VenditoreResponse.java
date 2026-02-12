package com.example.bff.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VenditoreResponse {
    Integer idVenditore;
    String nome;
    String cognome;
    String dataNascita;
}
