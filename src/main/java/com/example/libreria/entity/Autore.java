package com.example.libreria.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autore extends Persona{

    @Column(name = "website")
    @JsonProperty("website")
    private String website;

    @OneToMany(mappedBy = "autore")
    @ToString.Exclude
    private List<Libro> libri;

    @Column(name = "img_url")
    @JsonProperty("imgUrl")
    private String imgUrl;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
