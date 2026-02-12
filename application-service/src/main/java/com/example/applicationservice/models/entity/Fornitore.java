package com.example.applicationservice.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fornitore {

    @Id
    private Integer idFornitore;
    private String ragioneSociale;
    private String sedeLegale;

}
