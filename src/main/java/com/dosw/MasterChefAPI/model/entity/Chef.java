package com.dosw.MasterChefAPI.model.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.dosw.MasterChefAPI.model.entity.enums.ParticipantRole;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chef {

    @Id
    private String id;

    private String name;

    private ParticipantRole role;

    List<Recipe> recipes;
}
