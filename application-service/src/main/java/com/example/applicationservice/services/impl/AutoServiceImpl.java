package com.example.applicationservice.services.impl;

import com.example.applicationservice.models.entity.Auto;
import com.example.applicationservice.repository.AutoRepository;
import com.example.applicationservice.services.AutoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository ;


    @Transactional
    public Auto createAuto(Auto auto){

        auto.setCarburante(auto.getCarburante());
        auto.setPrezzo(auto.getPrezzo());
        auto.setChilometri(auto.getChilometri());
        auto.setModello(auto.getModello());
        auto.setAnnoImmatricolazione(auto.getAnnoImmatricolazione());
        return autoRepository.save(auto);
    }

    @Transactional
    public List<Auto> createAllAuto(List<Auto> autoList) {
        return autoRepository.saveAll(autoList);
    }


    public List<Auto> getAll() {
        return autoRepository.findAll();
    }

    public Auto getById(Integer id) {
        return autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto non trovata"));
    }

    @Transactional
    public void delete(Integer id) {
        autoRepository.deleteById(id);
    }



}
