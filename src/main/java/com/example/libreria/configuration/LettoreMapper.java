package com.example.libreria.configuration;

import com.example.libreria.DTO.LettoreDTO;
import com.example.libreria.entity.Lettore;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PersonaMapper.class)
public interface LettoreMapper {
    LettoreDTO toDto(Lettore lettore);
    List<LettoreDTO> toDtoList(List<Lettore> lettori);
}
