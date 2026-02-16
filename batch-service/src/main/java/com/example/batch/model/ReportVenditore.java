package com.example.batch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportVenditore {

    private Integer venditore;
    private Integer autoVendute;
    private Integer profittoGenerato;
    private Integer numeroClienti;
}

