package com.example.libreria.entity;

import com.example.libreria.enums.Genere;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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
    @Enumerated(EnumType.STRING)
//    @JsonProperty("genere")
    private Genere genere;

    @ManyToOne
    @JoinColumn(name = "id_persona") //FK verso Persona.idPersona
    @ToString.Exclude
    private Autore autore;

    @OneToMany(mappedBy = "libro")
    private List<Lettura> letture;


    @Column(name = "copertina_url")
    @JsonProperty("copertinaUrl")
    private String copertinaUrl;

    @Column(name = "descrizione",columnDefinition = "TEXT")
    @JsonProperty("descrizione")
    private String descrizione;

}
