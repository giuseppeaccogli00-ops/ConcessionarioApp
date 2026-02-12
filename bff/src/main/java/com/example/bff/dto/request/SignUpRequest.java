package com.example.bff.dto.request;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    @NotBlank//non può essere nullo, vuoto o fatto di spazi bianchi
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email//controlla che la mail inserita sia corretta
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
