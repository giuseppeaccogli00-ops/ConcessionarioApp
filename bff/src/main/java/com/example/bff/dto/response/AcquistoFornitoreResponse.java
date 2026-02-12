package com.example.bff.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AcquistoFornitoreResponse {
    Integer idAcquisto;
    String dataAcquistoFornitore;
    Integer costoAcquistoFornitore;
}

