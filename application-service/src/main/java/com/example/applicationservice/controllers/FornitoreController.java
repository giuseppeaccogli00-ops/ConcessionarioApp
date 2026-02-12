package com.example.applicationservice.controllers;

import com.example.applicationservice.models.entity.Fornitore;
import com.example.applicationservice.services.impl.FornitoreServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fornitores")
public class FornitoreController {

    private final FornitoreServiceImpl fornitoreService;


    @PostMapping
    public Fornitore create(@RequestBody Fornitore fornitore) {
        return fornitoreService.createFornitore(fornitore);
    }


    @GetMapping
    public List<Fornitore> getAll() {
        return fornitoreService.getAll();
    }


    @GetMapping("/{id}")
    public Fornitore getById(@PathVariable Integer id) {
        return fornitoreService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        fornitoreService.delete(id);
    }

}
