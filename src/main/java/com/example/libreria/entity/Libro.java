package com.example.libreria.entity;

import com.example.libreria.entity.en.Genere;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @Column(name = "titolo")
    @JsonProperty("titolo")
    private String titolo;

    @Column(name = "genere")
    @JsonProperty("genere")
    private Genere genere;

    @ManyToOne
    @JoinColumn(name = "idAutore")
    @ToString.Exclude
    private Autore autore;

    @OneToMany(mappedBy = "libro")
    private List<Lettura> letture;

    public Integer getIdLibro(){
        return this.idLibro;
    }

    public String getTitolo(){
        return this.titolo;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

    public Genere getGenere(){
        return this.genere;
    }

    public void setGenere( Genere genere){
        this.genere = genere;
    }

    public Autore getAutore() {
        return this.autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public List<Lettura> getListaLetture() {
        return this.letture;
    }



}
