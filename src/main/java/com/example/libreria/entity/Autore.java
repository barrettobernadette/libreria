package com.example.libreria.entity;

import com.example.libreria.entity.Persona;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutore;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "website")
    @JsonProperty("website")
    private String website;

    @OneToMany(mappedBy = "autore")
    @ToString.Exclude
    private List<Libro> libri;

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Libro> getLibri() {
        return this.libri;
    }
}
