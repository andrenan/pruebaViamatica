package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.jws.Oneway;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private final static String ACCES_TOKEN_SECRET = "ANB7xKhiUZmwltVd3f1odcHHM9VAwg02kwmLwtZwHv3SxGCOW";
    private final static Long ACCES_TOKEN_TIME = 2_592_000L;

    public static String createToken(String nombre, String email) {
        long expirationTime = ACCES_TOKEN_TIME * 1000;
        Date expirationDate = new Date(System.currentTimeMillis());

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.EMPTY_LIST);
        } catch (JwtException e) {
            return null;
        }
    }


}
