package com.example.authservice.repository;

import java.util.Optional;


import com.example.authservice.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);//l'Optional indice che potrebbi non esserci e quindi non fa generare errore a runtime

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
