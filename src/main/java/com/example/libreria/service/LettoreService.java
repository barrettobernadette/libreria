package com.example.libreria.service;

import com.example.libreria.DTO.LettoreDTO;
import com.example.libreria.configuration.LettoreMapper;
import com.example.libreria.entity.Lettore;
import com.example.libreria.entity.Lettura;
import com.example.libreria.entity.Libro;
import com.example.libreria.repository.LettoreRepository;
import com.example.libreria.repository.LetturaRepository;
import com.example.libreria.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LettoreService {
    @Autowired
    private  LettoreRepository lettoreRepository;
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private LetturaRepository letturaRepository;
    @Autowired
    private LettoreMapper lettoreMapper;

    @Transactional
    public boolean addLettore(Lettore lettore){
        try {
            lettoreRepository.save(lettore);
            if(lettore.getLetture()!= null && !lettore.getLetture().isEmpty()) {
                for (Lettura lettura : lettore.getLetture()) {
                    Libro libro = libroRepository.findById(lettura.getLibro().getIdLibro()).orElseThrow(() -> new RuntimeException("Libro non trovato"));

                    lettura.setLettore(lettore);
                    lettura.setLibro(libro);
                    letturaRepository.save(lettura);
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    public List<LettoreDTO> getListaLettore() throws IllegalAccessException {
        List<Lettore> lista;
        try {
            lista = lettoreRepository.findAll();
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return lettoreMapper.toDtoList(lista);
    }

    @Transactional
    public LettoreDTO getLettoreById (Integer id) throws IllegalAccessException {
        Optional<Lettore> lettore;
        try {
            lettore = lettoreRepository.findById(id);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return lettoreMapper.toDto(lettore.get());
    }
    @Transactional
    public String updateLettore (Lettore lettore) throws IllegalAccessException {
        try {
            lettoreRepository.save(lettore);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return "Lettore modificata con successo";
    }

    @Transactional
    public String deleteById (Integer id) throws IllegalAccessException {
        try {
            if (lettoreRepository.findById(id).isEmpty()){
                return "ID non esistente";
            }else {
                lettoreRepository.deleteById(id);
                return "Lettore eliminato con successo";
            }

        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
    }
}
