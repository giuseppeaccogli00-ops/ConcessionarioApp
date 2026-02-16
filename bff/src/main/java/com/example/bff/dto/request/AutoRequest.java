package com.example.bff.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AutoRequest {
    String modello;
    String annoImmatricolazione;
    Integer chilometri;
    String carburante;
    Integer prezzo;
}

