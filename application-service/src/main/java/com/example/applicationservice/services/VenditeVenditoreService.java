package com.example.applicationservice.services;


import com.example.applicationservice.models.entity.projection.VenditeVenditoreProjection;

import java.time.LocalDate;
import java.util.List;

public interface VenditeVenditoreService {

    List<VenditeVenditoreProjection> getReport(LocalDate start, LocalDate end);

}

