package com.example.libreria.configuration;

import com.example.libreria.DTO.AutoreDTO;
import com.example.libreria.DTO.PersonaDTO;
import com.example.libreria.entity.Autore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = PersonaMapper.class)
public interface AutoreMapper {
    AutoreDTO toDto(Autore autore);
    List<AutoreDTO> toDtoList(List<Autore> autori);
}
