package com.example.applicationservice.repository;

import com.example.applicationservice.models.entity.Vendita;
import com.example.applicationservice.models.entity.projection.VenditeVenditoreProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VenditeVenditoreRepository  extends JpaRepository<Vendita, Integer>{

    @Query(value = """
    SELECT
        VENDITORE                    AS venditore,
        COUNT(*)                     AS autoVendute,
        SUM(PREZZO)                  AS profittoGenerato,
        COUNT(DISTINCT ID_CLIENTE)   AS numeroClienti
    FROM VENDITE_VENDITORE
    WHERE TO_DATE(DATA, 'DD/MM/YYYY')
          BETWEEN :start AND :end
    GROUP BY VENDITORE
    ORDER BY profittoGenerato DESC
""", nativeQuery = true)
    List<VenditeVenditoreProjection> findByPeriodo(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end
    );

}

