package com.example.libreria.controllers;

import com.example.libreria.entity.Persona;
import com.example.libreria.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona")
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Boolean> addPersona(@RequestBody Persona persona) {
        boolean res = personaService.addPersona(persona);

        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Persona>> getListaPersone() {
        List<Persona> res = null;
        try {
            res = personaService.getListaPersone();
        } catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(res);
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public ResponseEntity<String> updatePersona(@RequestBody Persona persona) {
        String res = null;
        try {
            res = personaService.updateNome(persona);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        return  ResponseEntity.ok(res);
    }

    @DeleteMapping(value = "deleteById")
    public ResponseEntity<String> deleteById(@RequestParam Integer id) {
        String res = personaService.deleteById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "getById")
    public ResponseEntity<Persona> getPersonaById (@RequestParam Integer id) throws IllegalAccessException {
        Persona p;
        try {
            p = personaService.getPersonaById(id);
        } catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(p);
    }
}

