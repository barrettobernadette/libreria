package com.example.libreria.configuration;

import com.example.libreria.DTO.LibroDTO;
import com.example.libreria.entity.Libro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibroMapper {
    LibroDTO toDto(Libro libro);
    Libro toEntity(LibroDTO dto);
    List<LibroDTO> toDtoList(List<Libro> libri);

}
