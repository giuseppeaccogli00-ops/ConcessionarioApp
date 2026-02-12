package com.example.authservice.security.services;


import com.example.authservice.models.entity.User;
import com.example.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {//cerca user nel db a partire dall'username, spring security lo chiama ogni volta che si tenta di fare login
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));//se l'username non esiste viene lanciata un'eccezione e viene bloccato il login

        return UserDetailsImpl.build(user);
    }



//    @Override
//    public UserDetails updatePassword(UserDetails user, @Nullable String newPassword) {
//        return null;
//    }

}
