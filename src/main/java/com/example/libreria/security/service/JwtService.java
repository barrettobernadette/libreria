package com.example.libreria.security.service;

import com.example.libreria.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {
    @Value("${jwtSecretKey}")
    private String jwrSecretKey;
    public SecretKey signingKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwrSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateJwt(User user) {
        return Jwts.builder().subject(user.getUsername()).signWith(signingKey()).compact();
    }
}
