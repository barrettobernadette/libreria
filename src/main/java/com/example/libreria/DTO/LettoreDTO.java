package com.example.libreria.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LettoreDTO {
    private PersonaDTO persona;
    private Integer readingGoal;

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public Integer getReadingGoal() {
        return readingGoal;
    }

    public void setReadingGoal(Integer readingGoal) {
        this.readingGoal = readingGoal;
    }
}
