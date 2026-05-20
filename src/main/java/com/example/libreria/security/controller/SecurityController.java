package com.example.libreria.security.controller;

import com.example.libreria.entity.User;
import com.example.libreria.security.dto.UserAccessData;
import com.example.libreria.security.service.SecurityService;
import com.example.libreria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class SecurityController {

    @Autowired
    SecurityService securityService;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("Utente Registrato con successo");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
        @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAccessData userAccessData) {
        String jwt = null;

        //TODO chiamata a DB e recupero utenza con user.username == db.user.username
        //User user = userService.getUser(userAccessData.getUsername());
        //TODO verifica password codificata
        //Boolean isPasswordCorrect = securityService.checkPsw(userAccessData,user);

        jwt = securityService.login(userAccessData);

        return ResponseEntity.ok(jwt);
    }
}
