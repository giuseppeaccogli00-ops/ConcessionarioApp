package com.example.applicationservice.services.impl;

import com.example.applicationservice.models.entity.AcquistoFornitore;
import com.example.applicationservice.repository.AcquistoFornitoreRepository;
import com.example.applicationservice.services.AcquistoFornitoreService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AcquistoFornitoreServiceImpl implements AcquistoFornitoreService {

    private final AcquistoFornitoreRepository acquistoFornitoreRepository;

    public String addAcquistoFornitore(AcquistoFornitore acquistoFornitore){
        return "Acquisto Fornitore aggiunto";
    }

    public String removeAcquistoFornitore(AcquistoFornitore acquistoFornitore){
        return "Acquisto Fornitore rimosso";
    }
}
