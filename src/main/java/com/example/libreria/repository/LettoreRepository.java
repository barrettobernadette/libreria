package com.example.libreria.repository;

import com.example.libreria.entity.Lettore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LettoreRepository extends JpaRepository<Lettore,Integer> {
}
