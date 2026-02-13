package com.example.bff.controllers;

import com.example.bff.clients.VenditaClient;
import com.example.bff.dto.request.VenditaRequest;
import com.example.bff.dto.response.VenditaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendite")
@RequiredArgsConstructor
public class VenditaController {

    private final VenditaClient venditaClient;

    @PostMapping
    public VenditaResponse create(@RequestBody VenditaRequest request) {
        return venditaClient.create(request);
    }

    @PostMapping("/random")
    public void venditeRandom() { venditaClient.venditeRandom(); }

    @GetMapping
    public List<VenditaResponse> getAll() {
        return venditaClient.getAll();
    }
}

