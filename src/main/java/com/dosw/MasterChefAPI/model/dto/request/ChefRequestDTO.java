package com.dosw.MasterChefAPI.model.dto.request;

import com.dosw.MasterChefAPI.model.entity.enums.ParticipantRole;
import com.dosw.MasterChefAPI.model.entity.Recipe;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChefRequestDTO {

    @Schema(description = "Unique identifier of each chef", example = "12345678")
    @NotNull(message = "ID cannot be null")
    private String id;

    @Schema(description = "Name of the chef", example = "Juan Perez")
    @NotBlank(message = "The name cannot be blank")
    private String name;

    @Schema(description = "Role of the chef", example = "CONTESTANT")
    @NotNull(message = "The role cannot be null")
    private ParticipantRole role;

    @Schema(description = "List of recipes of each chef", example = "[Filet Mignon, Penne Pasta, Grill Chicken Breast]")
    private List<Recipe> recipes;

}
