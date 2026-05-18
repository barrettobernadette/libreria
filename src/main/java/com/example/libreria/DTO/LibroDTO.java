package com.example.libreria.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    private Integer idLibro;
    private String titolo;
    private String genere;
    private AutoreDTO autore;
    private String copertinaUrl;
    private String descrizione;
}

