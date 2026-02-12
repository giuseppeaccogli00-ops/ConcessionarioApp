package com.example.applicationservice.controllers;

import com.example.applicationservice.models.entity.Vendita;
import com.example.applicationservice.services.impl.VenditaServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/venditas")
public class VenditaController {

    private final VenditaServiceImpl venditaservice;

    @PostMapping
    public Vendita create(@RequestBody Vendita vendita) {
        return venditaservice.createVendita(vendita);
    }


    @GetMapping
    public List<Vendita> getAll() {
        return venditaservice.getAll();
    }


    @GetMapping("/{id}")
    public Vendita getById(@PathVariable Integer id) {
        return venditaservice.getById(id);
    }

    @GetMapping("/dettaglioVendita")
    public List<Vendita> getAutoVendute() {
        List<Vendita> vendite = venditaservice.getVenditeConAutoECliente();
        return vendite;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        venditaservice.delete(id);
    }

}
