package com.example.applicationservice.services.impl;

import com.example.applicationservice.models.entity.Venditore;
import com.example.applicationservice.repository.VenditoreRepository;
import com.example.applicationservice.services.VenditoreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class VenditoreServiceImpl implements VenditoreService {

    private static final Random RANDOM = new Random();
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

    public void venditoriRandom() {
        List<Venditore> venditori = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Venditore v = new Venditore();
            v.setNome(randomNome());
            v.setCognome(randomCognome());
            v.setDataNascita(randomDate());

            venditori.add(v);
        }

        venditoreRepository.saveAll(venditori);
    }


    @Transactional
    public void delete(Integer id) {
        venditoreRepository.deleteById(id);
    }

    private String randomNome() {
        String[] nomi = {"Mario", "Luca", "Anna", "Giulia", "Marco", "Sara", "Giovanni", "Gianfranco", "Francesca", "Giandomenico"};
        return nomi[RANDOM.nextInt(nomi.length)];
    }

    private String randomCognome() {
        String[] cognomi = {"Rossi", "Bianchi", "Verdi", "Neri", "Ferrari", "Armenise", "Valentini", "Bianchi", "Ramazzotti", "Esposito"};
        return cognomi[RANDOM.nextInt(cognomi.length)];
    }

    private String randomDate() {
        String[] date = {"25/12/2002", "7/09/1999", "3/3/2003", "25/02/2002", "20/10/2000", "19/11/2002", "09/09/1999", "21/04/2000", "12/05/1997", "10/08/1998"};
        return date[RANDOM.nextInt(date.length)];
    }

}
