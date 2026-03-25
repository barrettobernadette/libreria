package com.example.libreria.controllers;

import com.example.libreria.DTO.AutoreDTO;
import com.example.libreria.entity.Autore;
import com.example.libreria.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autore")
@CrossOrigin(origins = "*")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;
    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Boolean> addAutore(@RequestBody Autore autore) {
        boolean res = autoreService.addAutore(autore);

        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<AutoreDTO>> getListaAutori() {
        List<AutoreDTO> res = null;
        try {
            res = autoreService.getListaAutore();
        } catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "getById")
    public ResponseEntity<AutoreDTO> getAutoreById(@RequestParam Integer id) throws IllegalAccessException {
        AutoreDTO autore;
        try {
            autore = autoreService.getAutoreById(id);
        }catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(autore);
    }

    @DeleteMapping(value = "deleteById")
    public ResponseEntity<String> deleteById(@RequestParam Integer id) {
        String res;
        try {
             res = autoreService.deleteById(id);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body(null);
        } return ResponseEntity.ok(res);
    }

    @PutMapping(value = "update", consumes = "application/json")
    public ResponseEntity<String> update(@RequestBody Autore autore) {
        String res;
        try {
            res = autoreService.updateAutore(autore);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(res);
    }




}
