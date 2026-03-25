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
    @JoinColumn(name = "id_lettore")
    @ToString.Exclude
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

    public Integer getIdLettura() {
        return this.idLettura;
    }

    public void setIdLettura(Integer idLettura) {
        this.idLettura = idLettura;
    }

    public Lettore getLettore() {
        return this.lettore;
    }

    public void setLettore(Lettore lettore) {
        this.lettore = lettore;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getDataLettura() {
        return this.dataLettura;
    }

    public void setDataLettura(LocalDate dataLettura) {
        this.dataLettura = dataLettura;
    }

    public Integer getValutazione() {
        return this.valutazione;
    }

    public void setValutazione(Integer valutazione) {
        this.valutazione = valutazione;
    }

    public String getCommento() {
        return this.commento;
    }

    public  void setCommento(String commento) {
        this.commento = commento;
    }
}
