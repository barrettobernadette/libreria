package com.example.libreria.security.service;

import com.example.libreria.security.dto.UserAccessData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class SecurityService {
    @Value("${jwtSecretKey}")
    private String jwrSecretKey;

    public Boolean checkPsw(String psw) {
        return psw.equals("password");
    }

    public SecretKey signingKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwrSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateJwt(UserAccessData user) {
        return Jwts.builder().subject(user.getUsername()).expiration(new Date()).signWith(signingKey()).compact();
    }
}
