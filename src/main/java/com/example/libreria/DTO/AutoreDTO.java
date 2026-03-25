package com.example.libreria.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoreDTO {
    private Integer idAutore;
    private PersonaDTO persona;

    public Integer getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Integer idAutore) {
        this.idAutore = idAutore;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersonaDto(PersonaDTO persona) {
        this.persona = persona;
    }
}
