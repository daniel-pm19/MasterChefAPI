package com.dosw.MasterChefAPI.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequestDTO {

    @Schema(description = "The unique identifier for each recipe", example="1234567")
    @NotNull(message = "The ID cannot be null")
    private String id;

    @Schema(description = "Title of the recipe", example = "Filet Mignon")
    @NotBlank(message = "The title cannot be blank")
    private String title;

    @Schema(description = "A list of recipe's ingredients", example = "400gr of meat, 15g of butter")
    @NotBlank(message = "The ingredients list cannot be blank")
    private ArrayList<String> ingridients;

    @Schema(description = "A list of recipe's steps", example = "1. Put butter on the pan, 2. Add the meat to the pan")
    @NotBlank(message = "The steps list cannot be blank")
    private ArrayList<String> steps;

    @Schema(description = "Represents in wich season the recipe was made", example = "1")
    @NotBlank(message = "The season cannot be blank")
    private int season;

}
