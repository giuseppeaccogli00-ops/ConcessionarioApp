package com.example.applicationservice.services.impl;

import com.example.applicationservice.models.entity.Auto;
import com.example.applicationservice.models.entity.Cliente;
import com.example.applicationservice.models.entity.Vendita;
import com.example.applicationservice.models.entity.Venditore;
import com.example.applicationservice.repository.AutoRepository;
import com.example.applicationservice.repository.ClientRepository;
import com.example.applicationservice.repository.VenditaRepository;
import com.example.applicationservice.services.VenditaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class VenditaServiceImpl implements VenditaService {

    private final VenditaRepository venditaRepository;
    private final AutoRepository autoRepository;
    private final ClientRepository clienteRepository;

    @Override
    public List<Vendita> getVenditeConAutoECliente() {
        return venditaRepository.findAllVenditeWithAutoAndCliente();
    }


    @Transactional
    public Vendita createVendita(Vendita vendita) {

        Auto auto = autoRepository.findById(vendita.getAuto().getIdAuto())
                .orElseThrow(() -> new RuntimeException("Auto non trovata"));

        Cliente cliente = clienteRepository.findById(vendita.getCliente().getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente non trovato"));

        vendita.setAuto(auto);
        vendita.setCliente(cliente);

        return venditaRepository.save(vendita);
    }


    public List<Vendita> getAll() {
        return venditaRepository.findAll();
    }


    public Vendita getById(Integer id) {
        return venditaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendita non trovata"));
    }


    @Transactional
    public void delete(Integer id) {
        venditaRepository.deleteById(id);
    }
}
