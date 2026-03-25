package com.example.libreria.controllers;

import com.example.libreria.DTO.LettoreDTO;
import com.example.libreria.entity.Autore;
import com.example.libreria.entity.Lettore;
import com.example.libreria.service.LettoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lettore")
@CrossOrigin(origins = "*")
public class LettoreController {
    @Autowired
    private LettoreService lettoreService;

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Boolean> addLettore(@RequestBody Lettore lettore) {
        boolean res = lettoreService.addLettore(lettore);

        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<LettoreDTO>> getListaLettori() {
        List<LettoreDTO> res = null;
        try {
            res = lettoreService.getListaLettore();
        } catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "getById")
    public ResponseEntity<LettoreDTO> getLettoreById(@RequestParam Integer id) throws IllegalAccessException {
        LettoreDTO lettore;
        try {
            lettore = lettoreService.getLettoreById(id);
        }catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(lettore);
    }

    @DeleteMapping(value = "deleteById")
    public ResponseEntity<String> deleteById(@RequestParam Integer id) {
        String res;
        try {
            res = lettoreService.deleteById(id);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body(null);
        } return ResponseEntity.ok(res);
    }

    @PutMapping(value = "update", consumes = "application/json")
    public ResponseEntity<String> update(@RequestBody Lettore lettore) {
        String res;
        try {
            res = lettoreService.updateLettore(lettore);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(res);
    }
}
