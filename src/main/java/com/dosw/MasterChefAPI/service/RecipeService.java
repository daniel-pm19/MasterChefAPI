package com.dosw.MasterChefAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dosw.MasterChefAPI.exception.ResourceNotFoundException;
import com.dosw.MasterChefAPI.mapper.RecipeMapper;
import com.dosw.MasterChefAPI.model.dto.request.RecipeRequestDTO;
import com.dosw.MasterChefAPI.model.dto.response.RecipeResponseDTO;
import com.dosw.MasterChefAPI.model.entity.Recipe;
import com.dosw.MasterChefAPI.model.entity.enums.ParticipantRole;
import com.dosw.MasterChefAPI.repository.RecipeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {
    
    private RecipeRepository recipeRepository;

    private RecipeMapper recipeMapper;


    @Transactional
    public RecipeResponseDTO createRecipe(RecipeRequestDTO dto){
        Recipe recipe = Recipe.builder()
        .title(dto.getTitle())
        .authorChef(dto.getAuthorChef())
        .ingridients(dto.getIngridients())
        .steps(dto.getSteps())
        .season(dto.getSeason())
        .build();

        Recipe saved = recipeRepository.save(recipe);
        return recipeMapper.toDto(saved);
    }

    @Transactional
    public RecipeResponseDTO updateRecipe(String id, RecipeRequestDTO dto){
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> ResourceNotFoundException.create("ID", id));
        recipe.setTitle(dto.getTitle());
        recipe.setAuthorChef(dto.getAuthorChef());
        recipe.setIngridients(dto.getIngridients());
        recipe.setSteps(dto.getSteps());
        recipe.setSeason(dto.getSeason());
        
        Recipe updated = recipeRepository.save(recipe);
        return recipeMapper.toDto(updated);
    }

    @Transactional
    public void deleteRecipe(String id){
        if(!recipeRepository.existsById(id)){
            throw ResourceNotFoundException.create("ID", id);
        }
        recipeRepository.deleteById(id);
    }

    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    public RecipeResponseDTO getRecipeById(String id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.create("ID", id));
        return recipeMapper.toDto(recipe);
    }


    public List<RecipeResponseDTO> getRecipesByContestant() {
        return recipeRepository.findByAuthorChefRole(ParticipantRole.CONTESTANT)
                .stream().map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RecipeResponseDTO> getRecipesByViewer() {
        return recipeRepository.findByAuthorChefRole(ParticipantRole.VIEWER)
                .stream().map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }
    

    public List<RecipeResponseDTO> getRecipesByJudge() {
        return recipeRepository.findByAuthorChefRole(ParticipantRole.JUDGE)
                .stream().map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RecipeResponseDTO> getRecipesBySeason(int season) {
        return recipeRepository.findAllBySeason(season)
                .stream().map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RecipeResponseDTO> getRecipesByIngredient(String ingredient) {
        return recipeRepository.findByIngridientsContaining(ingredient)
                .stream().map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }
}
