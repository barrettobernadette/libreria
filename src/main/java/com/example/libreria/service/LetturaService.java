package com.example.libreria.service;

import com.example.libreria.DTO.LetturaDTO;
import com.example.libreria.mapper.LetturaMapper;
import com.example.libreria.entity.Lettore;
import com.example.libreria.entity.Lettura;
import com.example.libreria.entity.Libro;
import com.example.libreria.repository.LettoreRepository;
import com.example.libreria.repository.LetturaRepository;
import com.example.libreria.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service
public class LetturaService {
    @Autowired
    private LetturaRepository letturaRepository;
    @Autowired
    private LetturaMapper letturaMapper;
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private LettoreRepository lettoreRepository;

    @Autowired
    private ObjectMapper mapper;

    @Transactional
    public Boolean addLettura(Lettura lettura){
        Libro libro = libroRepository.findById(lettura.getLibro().getIdLibro())
                .orElseThrow(() ->new RuntimeException("Libro non trovato."));
        Lettore lettore = lettoreRepository.findById(lettura.getLettore().getIdPersona())
                .orElseThrow(()-> new RuntimeException("Lettore non trovato"));
        try {
            lettura.setLibro(libro);
            lettura.setLettore(lettore);
            letturaRepository.save(lettura);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    public List<LetturaDTO> getListaLetture() throws IllegalAccessException {
        List<Lettura> lista;
        try {
            lista = letturaRepository.findAll();
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return letturaMapper.toDtoList(lista);
    }

    @Transactional
    public LetturaDTO getLetturaById(Integer idLettura) throws IllegalAccessException {
        Optional<Lettura> lettura;
        try {
            lettura = letturaRepository.findById(idLettura);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return letturaMapper.toDto(lettura.get());
    }

    @Transactional
    public Lettura getListaByIdLibro(Integer idLibro) throws IllegalAccessException {
        List<Lettura> lista;
        try {
            lista = letturaRepository.findByLibroIdLibro(idLibro);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return (Lettura) lista;
    }

    @Transactional
    public Lettura getListaByIdPersona(Integer idPersona) throws IllegalAccessException {
        List<Lettura> lista;
        try {
            lista = letturaRepository.findByLettoreIdPersona(idPersona);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return (Lettura) lista;
    }

    @Transactional
    public String updateLettura(Lettura lettura) throws IllegalAccessException {
        if (lettura.getLettore() == null || lettura.getLibro() == null) {
            return "Controllare che i dati del libro o del lettore siano valorizzati correttamente";
        }
        try {
            letturaRepository.save(lettura);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return "Lettore modificato con successo";
    }
    @Transactional
    public String deleteById(Integer id) throws IllegalAccessException {
        try {
            if (letturaRepository.findById(id).isEmpty()){
                return "ID_Lettura non esistente";
            }else {
                letturaRepository.deleteById(id);
                return "Lettura eliminata con successo";
            }
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
    }
    @Transactional
    public List<LetturaDTO> getClassifica() throws IllegalAccessException {
        List<Lettura> lista;
        try {
            lista = letturaRepository.getClassifica();
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return letturaMapper.toDtoList(lista);
    }
}
