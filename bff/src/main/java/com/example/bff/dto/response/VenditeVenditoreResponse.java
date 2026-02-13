package com.example.bff.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VenditeVenditoreResponse {
    Integer venditore;
    Integer autoVendute;
    Integer profittoGenerato;
    Integer numeroClienti;
}
