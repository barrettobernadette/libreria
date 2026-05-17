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
    private LibroDTO libro;
    private LocalDate dataLettura;
    private String commento;
    private Integer valutazione;

}
