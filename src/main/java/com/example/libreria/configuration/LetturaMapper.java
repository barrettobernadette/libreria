package com.example.libreria.configuration;

import com.example.libreria.DTO.LetturaDTO;
import com.example.libreria.entity.Lettura;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LetturaMapper.class, LibroMapper.class})
public interface LetturaMapper {
    LetturaDTO toDto(Lettura lettura);
    List<LetturaDTO> toDtoList(List<Lettura> letture);
}
