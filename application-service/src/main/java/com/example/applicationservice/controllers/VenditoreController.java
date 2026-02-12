package com.example.applicationservice.controllers;

import com.example.applicationservice.models.entity.Venditore;
import com.example.applicationservice.services.impl.VenditoreServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/venditores")
public class VenditoreController {

    private final VenditoreServiceImpl venditoreService;


    @PostMapping
    public Venditore create(@RequestBody Venditore venditore) {
        return venditoreService.createVenditore(venditore);
    }


    @GetMapping
    public List<Venditore> getAll() {
        return venditoreService.getAll();
    }


    @GetMapping("/{id}")
    public Venditore getById(@PathVariable Integer id) {
        return venditoreService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        venditoreService.delete(id);
    }
}
