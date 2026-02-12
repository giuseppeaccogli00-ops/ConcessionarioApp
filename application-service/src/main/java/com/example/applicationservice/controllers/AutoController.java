package com.example.applicationservice.controllers;

import com.example.applicationservice.models.entity.Auto;
import com.example.applicationservice.services.impl.AutoServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/macchinas")
@RequiredArgsConstructor
public class AutoController {

    private final AutoServiceImpl autoService;

    @PostMapping
    public Auto createAuto(@RequestBody Auto auto) {
        return autoService.createAuto(auto);
    }

    @GetMapping
    public List<Auto> getAllAuto(){
        return autoService.getAll();
    }

    @GetMapping("/{id}")
    public Auto getAutoById(@PathVariable Integer id){
        return autoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void removeAuto(@PathVariable Integer id) {
        autoService.delete(id);
    }

}
