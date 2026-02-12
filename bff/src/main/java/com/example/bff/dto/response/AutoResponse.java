package com.example.bff.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AutoResponse {
    Integer idAuto;
    String modello;
    String annoImmatricolazione;
    Integer chilometri;
    String carburante;
    Integer prezzo;
}

