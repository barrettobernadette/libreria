package com.example.libreria.mapper;

import com.example.libreria.DTO.PersonaDTO;
import com.example.libreria.entity.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDTO toDto(Persona persona);
    //Persona toEntity(PersonaDTO dto);
    List<PersonaDTO> toDtoList(List<Persona> persone);
}
