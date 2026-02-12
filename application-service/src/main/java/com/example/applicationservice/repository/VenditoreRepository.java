package com.example.applicationservice.repository;


import com.example.applicationservice.models.entity.Venditore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenditoreRepository extends JpaRepository<Venditore,Integer> {
}
