package com.example.applicationservice.repository;


import com.example.applicationservice.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente,Integer> {

}
