package com.example.bff.controllers;

import com.example.bff.clients.VenditoreClient;
import com.example.bff.dto.request.VenditoreRequest;
import com.example.bff.dto.response.VenditoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venditori")
@RequiredArgsConstructor
public class VenditoreController {

    private final VenditoreClient venditoreClient;

    @PostMapping
    public VenditoreResponse create(
            @RequestBody VenditoreRequest request
    ) {
        return venditoreClient.create(request);
    }

    @PostMapping("/random")
    public void venditoriRandom() { venditoreClient.venditoriRandom(); }

    @GetMapping
    public List<VenditoreResponse> getAll() {
        return venditoreClient.getAll();
    }

    @GetMapping("/{id}")
    public VenditoreResponse getById(
            @PathVariable Integer id
    ) {
        return venditoreClient.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ) {
        venditoreClient.delete(id);
    }
}

