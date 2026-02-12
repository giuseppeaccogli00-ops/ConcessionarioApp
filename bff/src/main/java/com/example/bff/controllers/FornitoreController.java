package com.example.bff.controllers;

import com.example.bff.clients.FornitoreClient;
import com.example.bff.dto.request.FornitoreRequest;
import com.example.bff.dto.response.FornitoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornitori")
@RequiredArgsConstructor
public class FornitoreController {

    private final FornitoreClient fornitoreClient;

    @PostMapping
    public FornitoreResponse create(@RequestBody FornitoreRequest request) {
        return fornitoreClient.create(request);
    }

    @GetMapping
    public List<FornitoreResponse> getAll() {
        return fornitoreClient.getAll();
    }
}

