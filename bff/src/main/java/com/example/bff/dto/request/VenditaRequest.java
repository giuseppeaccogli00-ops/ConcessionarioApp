package com.example.bff.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VenditaRequest {
    Integer idVenditore;
    Integer idAuto;
    Integer idCliente;
    String data;
}

