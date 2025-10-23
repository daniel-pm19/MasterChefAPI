package com.dosw.MasterChefAPI.repository;

import java.util.Optional;
import java.util.List;

import com.dosw.MasterChefAPI.model.entity.Recipe;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String>{

    Optional<Recipe> findById(String id);

    Optional<Recipe> findByTitle(String title);

    List<Recipe> findAllRecipes();

    List<Recipe> findByIngredient(String ingredient);

    List<Recipe> findAllBySeason(int season);

}
