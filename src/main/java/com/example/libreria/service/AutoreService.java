package com.example.libreria.service;

import com.example.libreria.DTO.AutoreDTO;
import com.example.libreria.configuration.AutoreMapper;
import com.example.libreria.entity.Autore;
import com.example.libreria.repository.AutoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private AutoreMapper autoreMapper;

    @Transactional
    public boolean addAutore(Autore autore) {
        try {
            autoreRepository.save(autore);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    public List<AutoreDTO> getListaAutore() throws IllegalAccessException {
        List<Autore> lista;
        try {
            lista = autoreRepository.findAll();
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return autoreMapper.toDtoList(lista);
    }

    @Transactional
    public AutoreDTO getAutoreById (Integer id) throws IllegalAccessException {
        Optional<Autore> autore;
        try {
            autore = autoreRepository.findById(id);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return autoreMapper.toDto(autore.get());
    }

    @Transactional
    public String updateAutore (Autore autore) throws IllegalAccessException {
        try {
            autoreRepository.save(autore);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return "Autore modificata con successo";
    }

    @Transactional
    public String deleteById (Integer id) throws IllegalAccessException {
        try {
            if (autoreRepository.findById(id).isEmpty()){
                return "ID non esistente";
            }else {
                autoreRepository.deleteById(id);
                return "Autore eliminato con successo";
            }

        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
    }
}
