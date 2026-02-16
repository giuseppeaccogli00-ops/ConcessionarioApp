package com.example.applicationservice.controllers;

import com.example.applicationservice.models.entity.projection.VenditeVenditoreProjection;
import com.example.applicationservice.services.impl.VenditeVenditoreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class VenditeVenditoreController {

    private final VenditeVenditoreServiceImpl service;

    @GetMapping
    public List<VenditeVenditoreProjection> getReport(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return service.getReport(start, end);
    }
}

