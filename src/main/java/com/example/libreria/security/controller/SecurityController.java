package com.example.libreria.security.controller;

import com.example.libreria.security.dto.UserAccessData;
import com.example.libreria.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class SecurityController {

    @Autowired
    SecurityService securityService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAccessData user) {
        String jwt = null;

        //TODO chiamata a DB e recupero utenza con user.username == db.user.username

        //TODO verifica password codificata
        Boolean isPasswordCorrect = securityService.checkPsw(user.getPassword());

        if(!isPasswordCorrect) return ResponseEntity.status(403).body(null);

        jwt = securityService.generateJwt(user);

        return ResponseEntity.ok(jwt);
    }
}
