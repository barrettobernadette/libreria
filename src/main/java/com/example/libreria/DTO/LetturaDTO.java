package com.example.libreria.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LetturaDTO {
    private Integer idLettura;
    private LettoreDTO lettore;
    private LibroDTO libro;
    private LocalDate dataLettura;
    private String commento;
    private Integer valutazione;

    public Integer getIdLettura() {
        return idLettura;
    }

    public void setIdLettura(Integer idLettura) {
        this.idLettura = idLettura;
    }

    public LettoreDTO getLettore() {
        return lettore;
    }

    public void setLettore(LettoreDTO lettore) {
        this.lettore = lettore;
    }

    public LibroDTO getLibro() {
        return libro;
    }

    public void setLibro(LibroDTO libro) {
        this.libro = libro;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public LocalDate getDataLettura() {
        return dataLettura;
    }

    public void setDataLettura(LocalDate dataLettura) {
        this.dataLettura = dataLettura;
    }

    public Integer getValutazione() {
        return valutazione;
    }

    public void setValutazione(Integer valutazione) {
        this.valutazione = valutazione;
    }
}
