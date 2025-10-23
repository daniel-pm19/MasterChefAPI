package com.dosw.MasterChefAPI.mapper;

import org.mapstruct.Mapper;
import java.util.List;

import com.dosw.MasterChefAPI.model.dto.request.ChefRequestDTO;
import com.dosw.MasterChefAPI.model.dto.response.ChefResponseDTO;
import com.dosw.MasterChefAPI.model.entity.Chef;

@Mapper(componentModel = "spring")
public interface ChefMapper {

    Chef toEntity(ChefRequestDTO dto);

    ChefResponseDTO toDto(Chef chef);

    List<ChefResponseDTO> toDtoList(List<Chef> chefs);

    List<Chef> toEntityList(List<ChefRequestDTO> chefsDTO);

}
