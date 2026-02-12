package com.example.authservice.security.jwt;

import java.security.Key;
import java.util.Date;


import com.example.authservice.security.services.UserDetailsImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.util.WebUtils;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;//chiave segreta per firmare

    @Value("${bezkoder.app.jwtExpirationS}")
    private int jwtExpirationS;//durata token

    @Value("${bezkoder.app.jwtCookieName}")
    private String jwtCookie;//nome del cookie

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);//prende il cookie dalla request
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUser(userPrincipal);
        //maxAge è un giorno e indica quanto dura JWT
        //httpOnly(true) permetteche il JWT non sia accessibile da javascript
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/").maxAge(24 * 60 * 60).httpOnly(true).build();
        return cookie;
    }
//
    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();//logout
        return cookie;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));//crea la chiave per firmare e validare
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);//se firma errata, token scaduto o token malformato da le eccezioni
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

//    public String generateTokenFromUsername(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + (long)jwtExpirationS*1000))
//                .signWith(key(), SignatureAlgorithm.HS256)
//                .compact();
//    }

    public String generateTokenFromUser(UserDetailsImpl userDetails) {

        var roles = userDetails.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .toList();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", roles) // ✅ CLAIM FONDAMENTALE
                .setIssuedAt(new Date())
                .setExpiration(new Date(
                        System.currentTimeMillis() + jwtExpirationS * 1000L
                ))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }



//    public Claims getAllClaimsFromJwtToken(String token) {
//        return Jwts.parserBuilder()//crea oggetto parser che sa leggere e verificare i token JWT
//                .setSigningKey(key())//usa la secret key restituita da key() per verificare la signature del token
//                .build()
//                .parseClaimsJws(token)//verifica signature e scadenza del token
//                .getBody();//restituisce i claims
//    }

}
