package com.example.libreria.controllers;

import com.example.libreria.DTO.LibroDTO;
import com.example.libreria.entity.Libro;
import com.example.libreria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libro")
@CrossOrigin(origins = "*")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Boolean> addLibro(@RequestBody Libro libro) {
        boolean res = libroService.addLibro(libro);
        return ResponseEntity.ok(res);
    }
//@PostMapping(value = "/add", consumes = "application/json")
//public ResponseEntity<Boolean> addLibro(@RequestBody Libro libro) {
//    boolean res = libroService.addLibro(libro);
//    return ResponseEntity.ok(res);
//}
    @GetMapping(value = "all")
    public ResponseEntity<List<LibroDTO>> getLista() {
        List<LibroDTO> res = null;
        try {
            res = libroService.getListaLibri();
        } catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "getById")
    public ResponseEntity<LibroDTO> getById(@RequestParam Integer id) throws IllegalAccessException {
        LibroDTO libro;
        try {
            libro = libroService.getLibroById(id);
        }catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping(value = "deleteById")
    public ResponseEntity<String> deleteById(@RequestParam Integer id) {
        String res;
        try {
            res = libroService.deleteById(id);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body(null);
        } return ResponseEntity.ok(res);
    }

    @PutMapping(value = "update", consumes = "application/json")
    public ResponseEntity<String> update(@RequestBody Libro libro) {
        String res;
        try {
            res = libroService.updateLibro(libro);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(res);
    }

}
