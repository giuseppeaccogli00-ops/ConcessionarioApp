package com.example.bff.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteRequest {
    String nome;
    String cognome;
    String dataNascita;
}

