package com.dosw.MasterChefAPI.model.dto.response;

import java.util.ArrayList;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeResponseDTO {

    private int id;

    private String title;

    private ArrayList<String> ingridients;

    private ArrayList<String> steps;

    private int season;
    
}
