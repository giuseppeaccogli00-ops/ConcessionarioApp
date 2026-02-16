package com.example.batch.job;

import com.example.batch.model.ReportVenditore;
import com.example.batch.model.VenditaRow;
//import com.example.batch.processor.VenditeProcessor;
import com.example.batch.reader.VenditeItemReader;
import com.example.batch.writer.ReportWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class ReportVenditeJob {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    private final VenditeItemReader reader;
//    private final VenditeProcessor processor;
    private final ReportWriter writer;

    @Bean
    public Job ReportVenditeJob() {
        return new JobBuilder("ReportVenditeJob", jobRepository)
                .start(step())
                .build();
    }

    @Bean
    public Step step() {
        return new StepBuilder("ReportVenditeStep", jobRepository)
                .<ReportVenditore, ReportVenditore>chunk(100, transactionManager)
                .reader(reader)
                .writer(writer)
                .build();
    }
}

