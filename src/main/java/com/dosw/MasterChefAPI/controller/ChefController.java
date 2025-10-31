package com.dosw.MasterChefAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dosw.MasterChefAPI.model.dto.request.ChefRequestDTO;
import com.dosw.MasterChefAPI.model.dto.response.ChefResponseDTO;
import com.dosw.MasterChefAPI.service.ChefService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chefs")
@RequiredArgsConstructor
public class ChefController {
    
    private final ChefService chefService;


    @PostMapping("")
    public ResponseEntity<ChefResponseDTO> createRecipe(
            @Valid @RequestBody ChefRequestDTO dto) {
        ChefResponseDTO created = chefService.createChef(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChefResponseDTO> updatedRecipe(
            @Parameter(description = "Chef to be updated", required = true) @PathVariable String id,
            @Valid @RequestBody ChefRequestDTO dto) {
        ChefResponseDTO studentUpdated = chefService.updateChef(id, dto);

        return ResponseEntity.ok(studentUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(
            @Parameter(description = "Chef to be deleted", required = true) @PathVariable String id) {
        chefService.deleteChef(id);

        return ResponseEntity.noContent().build();
    }
}
