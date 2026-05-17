package com.example.libreria.repository;

import com.example.libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Integer> {
    Libro findByAutoreIdPersona(Integer idPersona);
}
