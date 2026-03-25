package com.example.libreria.security.controller;

import com.example.libreria.security.dto.UserAccessData;
import com.example.libreria.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String login(@RequestBody UserAccessData user) {
        String jwt = null;

        Boolean isPasswordCorrect = securityService.checkPsw(user.getPassword());

        if(!isPasswordCorrect) return null;

        Map<String, String> claims = new HashMap<>();
        claims.put("subject", user.getUsername());
        jwt = securityService.generateJwt(user);

        return jwt;
    }
}
