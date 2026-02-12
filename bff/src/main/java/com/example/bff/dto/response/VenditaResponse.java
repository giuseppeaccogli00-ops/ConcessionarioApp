package com.example.bff.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VenditaResponse {
    Integer idVendita;
    String data;
    String nomeCliente;
    String modelloAuto;
    String nomeVenditore;
}

