package com.example.libreria.entity;

import com.example.libreria.entity.en.Tipologia;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "persona")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column(name = "nome")
    @JsonProperty("nome")
    private  String nome;

    @Column(name = "tipologia")
    @JsonProperty("tipologia")
    // TODO mapping
    private Tipologia tipologia;


    public Integer getIdPersona() {
        return this.idPersona;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public Tipologia getTipologia(){
        return this.tipologia;
    }

    public void setTipologia(Tipologia tipologia){
        this.tipologia = tipologia;
    }

}
