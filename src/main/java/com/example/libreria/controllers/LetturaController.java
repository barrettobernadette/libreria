package com.example.libreria.controllers;

import com.example.libreria.DTO.LetturaDTO;
import com.example.libreria.entity.Lettura;
import com.example.libreria.service.LetturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lettura")
@CrossOrigin(origins = "*")
public class LetturaController {
    @Autowired
    private LetturaService letturaService;

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Boolean> addLibro(@RequestBody Lettura lettura) {
        boolean res = letturaService.addLettura(lettura);
        return ResponseEntity.ok(res);
    }
    @GetMapping(value = "all")
    public ResponseEntity<List<LetturaDTO>> getLista() {
        List<LetturaDTO> res = null;
        try {
            res = letturaService.getListaLetture();
        } catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "getById")
    public ResponseEntity<LetturaDTO> getById(@RequestParam Integer id) throws IllegalAccessException {
        LetturaDTO lettura;
        try {
            lettura = letturaService.getLetturaById(id);
        }catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(lettura);
    }

    @GetMapping(value = "getByIdLibro")
    public ResponseEntity<Lettura> getByIdLibro(@RequestParam Integer id) throws IllegalAccessException {
        Lettura lettura;
        try {
            lettura = letturaService.getListaByIdLibro(id);
        }catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(lettura);
    }

    @GetMapping(value = "getByIdLettore")
    public ResponseEntity<Lettura> getByIdLettore(@RequestParam Integer id) throws IllegalAccessException {
        Lettura lettura;
        try {
            lettura = letturaService.getListaByIdLettore(id);
        }catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(lettura);
    }

    @DeleteMapping(value = "deleteById")
    public ResponseEntity<String> deleteById(@RequestParam Integer id) {
        String res;
        try {
            res = letturaService.deleteById(id);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body(null);
        } return ResponseEntity.ok(res);
    }

    @PutMapping(value = "update", consumes = "application/json")
    public ResponseEntity<String> update(@RequestBody Lettura lettura) {
        String res;
        try {
            res = letturaService.updateLettura(lettura);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(res);
    }
}
