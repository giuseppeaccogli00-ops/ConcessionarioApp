package com.example.bff.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")//endpoint pubblico a cui possono accedere tutti
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")//accedono a questo endpoint solo utenti autenticati
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")//accedono solo utenti con ruolo moderatore
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")//accedono solo utenti con ruolo admin
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
