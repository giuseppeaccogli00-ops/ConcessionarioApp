package com.example.bff.controllers;

import com.example.bff.clients.AutoClient;
import com.example.bff.dto.request.AutoRequest;
import com.example.bff.dto.response.AutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/macchina")
@RequiredArgsConstructor
public class AutoController {

    private final AutoClient autoClient;

    @PostMapping
    public AutoResponse create(@RequestBody AutoRequest request) {
        return autoClient.create(request);
    }

    @PostMapping("/lista")
    public List<AutoResponse> createAllAuto(@RequestBody List<AutoRequest> autoList) {return autoClient.createAllAuto(autoList);}

    @GetMapping
    public List<AutoResponse> getAll() {
        return autoClient.getAll();
    }

    @GetMapping("/{id}")
    public AutoResponse getById(@PathVariable Integer id) {
        return autoClient.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        autoClient.delete(id);
    }
}

