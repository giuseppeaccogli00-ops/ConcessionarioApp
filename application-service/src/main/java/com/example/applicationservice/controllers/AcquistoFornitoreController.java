package com.example.applicationservice.controllers;

import com.example.applicationservice.models.entity.AcquistoFornitore;
import com.example.applicationservice.services.impl.AcquistoFornitoreServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autos")
public class AcquistoFornitoreController {

    private final AcquistoFornitoreServiceImpl acquistoFornitoreService;


    @PostMapping
    public String aggiungiAcquisto(@RequestBody AcquistoFornitore acquistoFornitore){
        return acquistoFornitoreService.addAcquistoFornitore(acquistoFornitore);
    }

    @DeleteMapping
    public String rimuoviAcquisto(@RequestBody AcquistoFornitore acquistoFornitore){
        return acquistoFornitoreService.removeAcquistoFornitore(acquistoFornitore);
    }
}
