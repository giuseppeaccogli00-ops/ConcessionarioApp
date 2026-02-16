package com.example.batch.reader;

import com.example.batch.model.ReportVenditore;
import com.example.batch.model.VenditaRow;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class VenditeItemReader extends JdbcCursorItemReader<ReportVenditore> {

    public VenditeItemReader(DataSource dataSource) {
        setDataSource(dataSource);
        setSql("""
                SELECT
                    VENDITORE                    AS VENDITORE,
                    COUNT(*)                     AS AUTO_VENDUTE,
                    SUM(PREZZO)                  AS PROFITTO_GENERATO,
                    COUNT(DISTINCT ID_CLIENTE)   AS NUMERO_CLIENTI
                FROM VENDITE_VENDITORE
                WHERE TO_DATE(TRIM(DATA), 'DD/MM/YYYY') BETWEEN DATE '2020-01-01' AND DATE '2025-01-01'
                GROUP BY VENDITORE
                ORDER BY PROFITTO_GENERATO DESC

        """);

        setRowMapper((rs, rowNum) -> {
            ReportVenditore v = new ReportVenditore();
            v.setVenditore(rs.getInt("VENDITORE"));
            v.setProfittoGenerato(rs.getInt("PROFITTO_GENERATO"));
            v.setNumeroClienti(rs.getInt("NUMERO_CLIENTI"));
            v.setAutoVendute(rs.getInt("AUTO_VENDUTE"));
            return v;
        });
    }
}

