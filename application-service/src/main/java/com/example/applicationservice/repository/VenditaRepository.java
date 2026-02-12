package com.example.applicationservice.repository;


import com.example.applicationservice.models.entity.Vendita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VenditaRepository extends JpaRepository<Vendita,Integer> {
    @Query("""
        SELECT v
        FROM Vendita v
        JOIN FETCH v.auto
        JOIN FETCH v.cliente
    """)
    List<Vendita> findAllVenditeWithAutoAndCliente();
}
