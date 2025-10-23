package com.dosw.MasterChefAPI.mapper;

import org.mapstruct.Mapper;
import java.util.List;

import com.dosw.MasterChefAPI.model.dto.request.RecipeRequestDTO;
import com.dosw.MasterChefAPI.model.dto.response.RecipeResponseDTO;
import com.dosw.MasterChefAPI.model.entity.Recipe;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    Recipe toEntity(RecipeRequestDTO dto);

    RecipeResponseDTO toDto(Recipe recipe);

    List<RecipeResponseDTO> toDtoList(List<Recipe> recipes);

    List<Recipe> toEntityList(List<RecipeRequestDTO> recipesDTO);
    
}
