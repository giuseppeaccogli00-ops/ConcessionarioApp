package com.example.applicationservice.models.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "auto_generator")
    @SequenceGenerator(
            name="auto_generator",
            sequenceName = "auto_sequence_name",
            allocationSize = 1
    )
    private Integer idAuto;
    private String modello;
    private String annoImmatricolazione;
    private Integer chilometri;
    private String carburante;
    @Column(nullable = false)
    private Integer prezzo;


    @Override
    public String toString() {
        return "Auto: \n" +
                "{id= " + idAuto +
                ", modello='" + modello +
                ", annoImmatricolazione=" + annoImmatricolazione +
                ", chilometri=" + chilometri +
                ", carburante='" + carburante +
                ", prezzo=" + prezzo +
                '}';
    }
}
