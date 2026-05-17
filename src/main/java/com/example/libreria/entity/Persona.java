package com.example.libreria.entity;

import com.example.libreria.entity.en.Tipologia;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@MappedSuperclass
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column(name = "nome")
    @JsonProperty("nome")
    private  String nome;

    @Column(name = "cognome")
    @JsonProperty("cognome")
    private  String cognome;

}
