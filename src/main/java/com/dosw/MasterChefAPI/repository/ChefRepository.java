package com.dosw.MasterChefAPI.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dosw.MasterChefAPI.model.entity.Chef;
import com.dosw.MasterChefAPI.model.entity.enums.ParticipantRole;;

public interface ChefRepository extends MongoRepository<Chef, String> {

    Optional<Chef> findById(String id);

    List<Chef> findByRole(ParticipantRole role);

    Optional<Chef> findByRoleAndId(ParticipantRole role, String id);

    List<Chef> findAllChefs();

    List<Chef> findAllByRole(ParticipantRole role);

    
}
