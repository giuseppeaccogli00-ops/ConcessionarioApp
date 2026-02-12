package com.example.bff.controllers;

import com.example.bff.clients.ClienteClient;
import com.example.bff.dto.request.ClienteRequest;
import com.example.bff.dto.response.ClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clienti")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteClient clienteClient;

    @PostMapping
    public ClienteResponse create(@RequestBody ClienteRequest request) {
        return clienteClient.create(request);
    }

    @GetMapping
    public List<ClienteResponse> getAll() {
        return clienteClient.getAll();
    }
}

