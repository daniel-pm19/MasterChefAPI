package com.dosw.MasterChefAPI.service;

import org.springframework.stereotype.Service;


import com.dosw.MasterChefAPI.exception.ResourceNotFoundException;
import com.dosw.MasterChefAPI.mapper.ChefMapper;
import com.dosw.MasterChefAPI.model.dto.request.ChefRequestDTO;
import com.dosw.MasterChefAPI.model.dto.response.ChefResponseDTO;
import com.dosw.MasterChefAPI.model.entity.Chef;
import com.dosw.MasterChefAPI.repository.ChefRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class ChefService {

    private ChefRepository chefRepository;

    private ChefMapper chefMapper;

    @Transactional
    public ChefResponseDTO createChef(ChefRequestDTO dto){
        Chef chef = Chef.builder()
            .id(dto.getId())
            .name(dto.getName())
            .role(dto.getRole())
            .recipes(dto.getRecipes())
            .build();

        Chef saved = chefRepository.save(chef);
        return chefMapper.toDto(saved);
    }

    @Transactional
    public ChefResponseDTO updateChef(String id, ChefRequestDTO dto){
        Chef chef = chefRepository.findById(id).orElseThrow(() -> ResourceNotFoundException.create("ID", id));
        chef.setName(dto.getName());
        chef.setRole(dto.getRole());
        chef.setRecipes(dto.getRecipes());
        Chef updated = chefRepository.save(chef);
        return chefMapper.toDto(updated);
    }

    @Transactional
    public void deleteChef(String id){
        if(!chefRepository.existsById(id)){
            throw ResourceNotFoundException.create("ID", id);
        }
        chefRepository.deleteById(id);
    } 
    
}
