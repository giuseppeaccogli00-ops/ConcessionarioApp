package com.example.bff.controllers;


import com.example.bff.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/jwt")

public class DebugController {

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/details")
    public ResponseEntity<?> viewUserDetails( @AuthenticationPrincipal UserDetails jwt) {//ResponseEntity<?> significa che il tipo del body della risposta può essere di qualisasi tipo

//        String jwt = jwtUtils.getJwtFromCookies(request);
//
//        if (jwt == null) {
//            return ResponseEntity
//                    .status(HttpStatus.UNAUTHORIZED)
//                    .body("JWT not found in cookies");
//        }
//
//        Claims claims = jwtUtils.getAllClaimsFromJwtToken(jwt);

        return ResponseEntity.ok(jwt);
    }

}

