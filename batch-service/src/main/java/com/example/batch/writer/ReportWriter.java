package com.example.batch.writer;

import com.example.batch.model.ReportVenditore;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ReportWriter
        extends JdbcBatchItemWriter<ReportVenditore> {

    public ReportWriter(DataSource dataSource) {
        setDataSource(dataSource);
        setSql("""
            INSERT INTO REPORT_VENDITE_VENDITORE
            (VENDITORE, AUTO_VENDUTE, PROFITTO_GENERATO, NUMERO_CLIENTI)
            VALUES (?, ?, ?, ?)
        """);

        setItemPreparedStatementSetter((item, ps) -> {
            ps.setInt(1, item.getVenditore());
            ps.setInt(2, item.getAutoVendute());
            ps.setInt(3, item.getProfittoGenerato());
            ps.setInt(4, item.getNumeroClienti());
        });
    }
}

