package com.example.libreria.security.controller;

import com.example.libreria.DTO.SignupRequestDTO;
import com.example.libreria.entity.User;
import com.example.libreria.security.dto.UserAccessData;
import com.example.libreria.security.service.SecurityService;
import com.example.libreria.service.SignupService;
import com.example.libreria.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
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
    @Autowired
    private SignupService signupService;

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("Utente Registrato con successo");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserAccessData userAccessData, HttpServletResponse response) {
        securityService.login(userAccessData,response);
        return ResponseEntity.ok(Map.of("message","Login effettuato"));
    }

    @PostMapping("logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        securityService.logout(response);
        return ResponseEntity.ok().build();
    }

    @PostMapping("signup")
    public ResponseEntity<Void> signup(@RequestBody SignupRequestDTO request) {
        signupService.register(request);
        return ResponseEntity.ok().build();
    }
}
