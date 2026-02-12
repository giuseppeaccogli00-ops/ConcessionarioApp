package com.example.bff.jwt;

import java.io.IOException;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;



public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    //Intercetta ogni richiesta HTTP
    //controlla se esiste JWT valido
    //Se esiste autentica l'utente in SPRING Security
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {//metodo chiamato ad ogni richiesta HTTP
        try {
            String jwt = jwtUtils.getJwtFromCookies(request);//prendo il token dai cookies
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);//ottiene username, passowrd e ruolo dell'utente
                var authorities = jwtUtils.getAuthorities(jwt);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(username,
                                null,
                                authorities);//crea oggetto per l'utente che dice che questo utente è autenticato con questi dettagli

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));//aggiunge IP e session ID

                SecurityContextHolder.getContext().setAuthentication(authentication);//salvo utente nel SecurityContext
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }

//    private String parseJwt(HttpServletRequest request) {
//        String jwt = jwtUtils.getJwtFromCookies(request);
//        return jwt;
//    }
}
