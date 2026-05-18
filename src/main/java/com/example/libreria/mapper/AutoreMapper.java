package com.example.libreria.mapper;

import com.example.libreria.DTO.AutoreDTO;
import com.example.libreria.entity.Autore;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PersonaMapper.class)
public interface AutoreMapper {
    AutoreDTO toDto(Autore autore);
    List<AutoreDTO> toDtoList(List<Autore> autori);
}
