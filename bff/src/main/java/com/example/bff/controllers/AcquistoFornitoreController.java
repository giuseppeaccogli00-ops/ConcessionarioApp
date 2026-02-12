package com.example.bff.controllers;

import com.example.bff.clients.AcquistoFornitoreClient;
import com.example.bff.dto.request.AcquistoFornitoreRequest;
import com.example.bff.dto.response.AcquistoFornitoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acquisti-fornitori")
@RequiredArgsConstructor
public class AcquistoFornitoreController {

    private final AcquistoFornitoreClient acquistoFornitoreClient;

    @PostMapping
    public AcquistoFornitoreResponse create(
            @RequestBody AcquistoFornitoreRequest request
    ) {
        return acquistoFornitoreClient.create(request);
    }

    @GetMapping
    public List<AcquistoFornitoreResponse> getAll() {
        return acquistoFornitoreClient.getAll();
    }

    @GetMapping("/{id}")
    public AcquistoFornitoreResponse getById(
            @PathVariable Integer id
    ) {
        return acquistoFornitoreClient.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ) {
        acquistoFornitoreClient.delete(id);
    }
}

