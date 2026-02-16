package com.example.applicationservice.services.impl;

import com.example.applicationservice.models.entity.projection.VenditeVenditoreProjection;
import com.example.applicationservice.repository.VenditeVenditoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VenditeVenditoreServiceImpl {

    private final VenditeVenditoreRepository repository;

    public List<VenditeVenditoreProjection> getReport(LocalDate start, LocalDate end) {
        return repository.findByPeriodo(start, end);
    }
}
