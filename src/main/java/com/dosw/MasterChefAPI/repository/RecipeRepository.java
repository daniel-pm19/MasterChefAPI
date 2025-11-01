package com.dosw.MasterChefAPI.repository;

import java.util.Optional;
import java.util.List;

import com.dosw.MasterChefAPI.model.entity.Recipe;
import com.dosw.MasterChefAPI.model.entity.enums.ParticipantRole;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String>{

    Optional<Recipe> findById(String id);

    Optional<Recipe> findByTitle(String title);

    List<Recipe> findAll();

    List<Recipe> findByAuthorChefId(String id);

    List<Recipe> findByAuthorChefRole(ParticipantRole role);

    List<Recipe> findByIngridientsContaining(String ingredient);

    List<Recipe> findAllBySeason(int season);

}
