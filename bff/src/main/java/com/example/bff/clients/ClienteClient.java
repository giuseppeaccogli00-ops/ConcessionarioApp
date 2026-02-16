package com.example.bff.clients;

import com.example.bff.dto.request.ClienteRequest;
import com.example.bff.dto.response.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "application-cliente-client", url = "http://localhost:8081")
public interface ClienteClient {

    @PostMapping("/clientes")
    ClienteResponse create(@RequestBody ClienteRequest request);

    @PostMapping("/clientes/lista")
    List<ClienteResponse> createAllCliente(@RequestBody List<ClienteRequest> clientiList);

    @GetMapping("/clientes")
    List<ClienteResponse> getAll();
}

