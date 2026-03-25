package com.example.libreria.service;

import com.example.libreria.entity.Persona;
import com.example.libreria.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public boolean addPersona(Persona persona){
        try {
            personaRepository.save(persona);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Persona> getListaPersone() throws IllegalAccessException {
        List<Persona> lista;
        try {
            lista = personaRepository.findAll();
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return lista;
    }

    public Persona getPersonaById(Integer id) throws IllegalAccessException {
        Optional<Persona> persona;
        try {
            persona = personaRepository.findById(id);
        } catch (Exception e) {
            throw new IllegalAccessException("Errore");
        }
        return persona.get();
    }

    public String updateNome(Persona persona) {
        try {
            persona.getNome().isEmpty();
        } catch (NullPointerException e) {
            throw e;
        }
        try {
            Persona p = getPersonaById(persona.getIdPersona());
            p.setNome(persona.getNome());
            personaRepository.save(p);

        } catch (Exception e) {
            throw new RuntimeException("Errore");
        }
        return "Persona modificata con successo";
    }

    public String deleteById(Integer id) {
        Optional<Persona> p;
        try {
            p = personaRepository.findById(id);
            if (p.isEmpty()){
                return "ID non esistente";
            }else {
                personaRepository.deleteById(id);
                return "Persona eliminata con successo";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
