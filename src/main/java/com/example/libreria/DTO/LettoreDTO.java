package com.example.libreria.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LettoreDTO {
    private Integer id;
    private String nome;
    private String cognome;
    private String readingGoal;
}
