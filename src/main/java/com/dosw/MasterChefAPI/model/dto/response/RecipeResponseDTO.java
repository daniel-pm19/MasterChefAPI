package com.dosw.MasterChefAPI.model.dto.response;

import java.util.ArrayList;

import com.dosw.MasterChefAPI.model.entity.Chef;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeResponseDTO {

    private String id;

    private String title;

    private Chef authorChef;

    private ArrayList<String> ingridients;

    private ArrayList<String> steps;

    private int season;
    
}
