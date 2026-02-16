package com.example.applicationservice.controllers;

import com.example.applicationservice.models.entity.Auto;
import com.example.applicationservice.models.entity.Cliente;
import com.example.applicationservice.services.impl.ClientServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClientServiceImpl clienteService;

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @PostMapping("/lista")
    public List<Cliente> createAllClienti(@RequestBody List<Cliente> clientiList) {return clienteService.createAllCliente(clientiList);}


    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }


    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Integer id) {
        return clienteService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        clienteService.delete(id);
    }

}

