package com.example.libreria.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lettura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLettura;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    @ToString.Exclude //serve a evitare che Lombok includa quel campo nel metodo toString() generato automaticamente
    private Lettore lettore;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    @ToString.Exclude
    private Libro libro;

    @Column(name = "data_lettura")
    @JsonProperty("dataLettura")
    private LocalDate dataLettura;

    @Column(name = "valutazione")
    @JsonProperty("valutazione")
    private Integer valutazione;

    @Column(name = "commento")
    @JsonProperty("commento")
    private String commento;

}
