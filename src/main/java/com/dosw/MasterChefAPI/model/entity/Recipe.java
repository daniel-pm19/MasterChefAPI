package com.dosw.MasterChefAPI.model.entity;
import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


import lombok.Builder;
import lombok.Data;

@Document(collection = "recipes")
@Data
@Builder
public class Recipe {

    @Id
    private String id;
    
    private String title;

    private Chef authorChef;
    
    private ArrayList<String> ingridients;
    
    private ArrayList<String> steps;
    
    private int season;

    
}
