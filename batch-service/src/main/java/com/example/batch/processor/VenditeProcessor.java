package com.example.batch.processor;

import com.example.batch.model.ReportVenditore;
import com.example.batch.model.VenditaRow;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class VenditeProcessor
        implements ItemProcessor<ReportVenditore, ReportVenditore> {

    @Override
    public ReportVenditore process(ReportVenditore item) {
        return item; // non fa nulla
    }
}

