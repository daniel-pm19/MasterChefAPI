package com.dosw.MasterChefAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dosw.MasterChefAPI.model.dto.request.RecipeRequestDTO;
import com.dosw.MasterChefAPI.model.dto.response.RecipeResponseDTO;
import com.dosw.MasterChefAPI.service.RecipeService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {
    
    private final RecipeService recipeService;

    @GetMapping("")
    public ResponseEntity<List<RecipeResponseDTO>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }


    @PostMapping("")
    public ResponseEntity<RecipeResponseDTO> createRecipe(
            @Valid @RequestBody RecipeRequestDTO dto) {
        RecipeResponseDTO created = recipeService.createRecipe(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> updatedRecipe(
            @Parameter(description = "Recipe to be updated", required = true) @PathVariable String id,
            @Valid @RequestBody RecipeRequestDTO dto) {
        RecipeResponseDTO studentUpdated = recipeService.updateRecipe(id, dto);

        return ResponseEntity.ok(studentUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(
            @Parameter(description = "Recipe to be deleted", required = true) @PathVariable String id) {
        recipeService.deleteRecipe(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> consultRecipeById(@PathVariable String id) {

        return ResponseEntity.ok(recipeService.getRecipeById(id));

    }

    @GetMapping("/contestants")
    public ResponseEntity<List<RecipeResponseDTO>> getRecipesByContestant() {
        return ResponseEntity.ok(recipeService.getRecipesByContestant());
    }

    @GetMapping("/viewers")
    public ResponseEntity<List<RecipeResponseDTO>> getRecipesByViewer() {
        return ResponseEntity.ok(recipeService.getRecipesByViewer());
    }

    @GetMapping("/judges")
    public ResponseEntity<List<RecipeResponseDTO>> getRecipesByJudge() {
        return ResponseEntity.ok(recipeService.getRecipesByJudge());
    }

    @GetMapping("/season/{season}")
    public ResponseEntity<List<RecipeResponseDTO>> getRecipesBySeason(
            @Parameter(description = "Número de temporada", required = true)
            @PathVariable int season) {
        return ResponseEntity.ok(recipeService.getRecipesBySeason(season));
    }

    @GetMapping("/ingredient/{ingredient}")
    public ResponseEntity<List<RecipeResponseDTO>> getRecipesByIngredient(
            @Parameter(description = "Ingrediente a buscar", required = true)
            @PathVariable String ingredient) {
        return ResponseEntity.ok(recipeService.getRecipesByIngredient(ingredient));
    }
}
