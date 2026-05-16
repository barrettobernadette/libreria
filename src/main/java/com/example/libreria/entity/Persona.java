package com.example.libreria.entity;

import com.example.libreria.entity.en.Tipologia;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
public abstract class Persona {

    @Column(name = "nome")
    @JsonProperty("nome")
    private  String nome;

    @Column(name = "cognome")
    @JsonProperty("cognome")
    private  String cognome;

}
