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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor

public class VenditaServiceImpl implements VenditaService {

    private final VenditaRepository venditaRepository;
    private final AutoRepository autoRepository;
    private final ClientRepository clienteRepository;
    private final Random RANDOM = new Random();

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

    @Async
    public void venditeRandomAsync() {
        venditeRandom();
    }

    @Transactional
    public void venditeRandom() {
        List<Vendita> vendite = new ArrayList<>();
        List<Auto> autoList = autoRepository.findAll();
        List<Cliente> clientiList = clienteRepository.findAll();

        for (int i = 0; i < 50000; i++) {
            Vendita ve = new Vendita();
            ve.setAuto(autoList.get(RANDOM.nextInt(autoList.size())));
            ve.setCliente(clientiList.get(RANDOM.nextInt(clientiList.size())));
            ve.setData(randomDate());
            ve.setIdVenditore(randomVenditoreId());

            vendite.add(ve);
        }

        venditaRepository.saveAll(vendite);
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

    private String randomDate() {
        String[] date = {"25/12/2017", "7/09/2018", "3/3/2019", "25/02/2020", "20/10/2021", "19/11/2022", "09/09/2023", "21/04/2024", "12/05/2025", "10/08/2025"};
        return date[RANDOM.nextInt(date.length)];
    }

    private Integer randomVenditoreId() {
        return RANDOM.nextInt(20) + 21; // venditori da 1 a 20
    }
}
