package com.dosw.MasterChefAPI.model.entity;
import java.util.List;

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
    
    private List<String> ingridients;
    
    private List<String> steps;
    
    private int season;

    
}
