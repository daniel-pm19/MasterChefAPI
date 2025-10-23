package com.dosw.MasterChefAPI.model.dto.response;

import com.dosw.MasterChefAPI.model.entity.enums.ParticipantRole;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChefResponseDTO {
    
    private String name;

    private ParticipantRole role;
    
}
