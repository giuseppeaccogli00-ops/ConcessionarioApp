package com.example.authservice.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.authservice.models.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@Getter
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String email;

    @JsonIgnore//evita che la password finisca in json, serve per serializzarla
    private String password;

    private Collection<? extends GrantedAuthority> authorities;//qui ci sono ruoli e permessi


    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> {
                    return new SimpleGrantedAuthority(role.getName().name());
                })
                .collect(Collectors.toList());//converte i ruoli di user in una lista di authorities

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }


    @Override
    public boolean isAccountNonExpired() {//metodi che SPRING Security chiama automaticamente
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {//mi dice che due utenti sono uguali solo se hanno lo stesso id
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
