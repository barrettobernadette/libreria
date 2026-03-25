package com.example.libreria.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backoffice")
public class BackOffice {
    @GetMapping("/test")
    public ResponseEntity<String> backofficeTest() {
        return ResponseEntity.ok("ok");
    }
}
