package com.example.bff.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteResponse {
    Integer idCliente;
    String nome;
    String cognome;
    String dataNascita;
}

