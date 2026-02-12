package com.example.bff.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FornitoreResponse {
    Integer idFornitore;
    String ragioneSociale;
    String sedeLegale;
}

