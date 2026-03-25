package com.example.libreria.service;


import com.example.libreria.DTO.LibroDTO;
import com.example.libreria.configuration.LibroMapper;
import com.example.libreria.entity.Libro;
import com.example.libreria.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private LibroMapper libroMapper;


    public boolean addLibro(Libro libro){
        try {
            libroRepository.save(libro);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
//public boolean addLibro(Libro libro){
//    try {
//        libroRepository.save(libro);
//    } catch (Exception e) {
//        return false;
//    }
//    return true;
//}

    @Transactional
    public List<LibroDTO> getListaLibri() throws IllegalAccessException {
        List<Libro> lista;
        try {
            lista = libroRepository.findAll();
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return libroMapper.toDtoList(lista);
    }

//    @Transactional
//    public Libro getLibroById(Integer id) throws IllegalAccessException {
//        Libro libro = libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro non trovato"));
//        return libro;
//    }
    @Transactional
    public LibroDTO getLibroById(Integer id) throws IllegalAccessException {
        Libro libro = libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro non trovato"));
        return libroMapper.toDto(libro);
    }


    @Transactional
    public String updateLibro (Libro libro) throws IllegalAccessException {
        try {
            libroRepository.save(libro);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return "Libro modificata con successo";
    }

    @Transactional
    public String deleteById (Integer id) throws IllegalAccessException {
        try {
            if (libroRepository.findById(id).isEmpty()){
                return "ID non esistente";
            }else {
                libroRepository.deleteById(id);
                return "Libro eliminato con successo";
            }

        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
    }
}
