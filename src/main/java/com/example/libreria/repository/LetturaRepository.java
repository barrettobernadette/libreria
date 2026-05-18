package com.example.libreria.repository;

import com.example.libreria.entity.Lettura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetturaRepository extends JpaRepository<Lettura,Integer> {
    List<Lettura> findByLettoreIdPersona
            (Integer idPersona);
    List<Lettura> findByLibroIdLibro(Integer idLibro);
    //per recuperare tutte le letture tramite gli idLibro e idLettore

    @Query(value = "SELECT * FROM Lettura ORDER BY valutazione DESC LIMIT 3", nativeQuery = true)
    List<Lettura> getClassifica();
}
