package com.example.applicationservice.services.impl;

import com.example.applicationservice.models.entity.Venditore;
import com.example.applicationservice.repository.VenditoreRepository;
import com.example.applicationservice.services.VenditoreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenditoreServiceImpl implements VenditoreService {

    private final VenditoreRepository venditoreRepository;

    @Transactional
    public Venditore createVenditore(Venditore venditore) {
        return venditoreRepository.save(venditore);
    }


    public List<Venditore> getAll() {
        return venditoreRepository.findAll();
    }


    public Venditore getById(Integer id) {
        return venditoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venditore non trovato"));
    }


    @Transactional
    public void delete(Integer id) {
        venditoreRepository.deleteById(id);
    }

}
