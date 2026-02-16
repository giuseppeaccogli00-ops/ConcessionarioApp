package com.example.bff.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AcquistoFornitoreRequest {
    Integer idFornitore;
    Integer idAuto;
    String dataAcquistoFornitore;
    Integer costoAcquistoFornitore;
}

