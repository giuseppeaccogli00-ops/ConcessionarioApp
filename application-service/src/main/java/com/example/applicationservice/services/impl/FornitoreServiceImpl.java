package com.example.applicationservice.services.impl;

import com.example.applicationservice.models.entity.Fornitore;
import com.example.applicationservice.repository.FornitoreRepository;
import com.example.applicationservice.services.FornitoreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornitoreServiceImpl implements FornitoreService {

    private final FornitoreRepository fornitoreRepository;

    @Transactional
    public Fornitore createFornitore(Fornitore fornitore) {
        return fornitoreRepository.save(fornitore);
    }


    public List<Fornitore> getAll() {
        return fornitoreRepository.findAll();
    }


    public Fornitore getById(Integer id) {
        return fornitoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornitore non trovato"));
    }

    @Transactional
    public void delete(Integer id) {
        fornitoreRepository.deleteById(id);
    }

}
