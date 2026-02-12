package com.example.applicationservice.repository;


import com.example.applicationservice.models.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto,Integer> {

}
