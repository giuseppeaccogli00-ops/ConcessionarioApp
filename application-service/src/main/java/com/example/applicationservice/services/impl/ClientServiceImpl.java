package com.example.applicationservice.services.impl;

import com.example.applicationservice.models.entity.Cliente;
import com.example.applicationservice.repository.ClientRepository;
import com.example.applicationservice.services.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clienteRepository;

    @Transactional
    public Cliente createCliente(Cliente cliente) {

        cliente.setIdCliente(cliente.getIdCliente());
        cliente.setNome(cliente.getNome());
        cliente.setCognome(cliente.getCognome());
        cliente.setDataNascita(cliente.getDataNascita());

        clienteRepository.save(cliente);
        return cliente;
    }


    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente non trovato"));
    }

    @Transactional
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
