package com.example.libreria.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoreDTO {
    private Integer idPersona;
    private String nome;
    private String cognome;
    private String website;
    private String imgUrl;
}
