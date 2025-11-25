package com.lodgeservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.lodgeservice.dtos.LodgeCreationDTO;
import com.lodgeservice.dtos.LodgeResponseDTO;
import com.lodgeservice.entity.Lodge;

@Component
public class LodgeMapper {

    // DTO → Entity
    public Lodge toEntity(LodgeCreationDTO dto) {
        Lodge lodge = new Lodge();
        lodge.setId(dto.getId());
        lodge.setOwnerId(dto.getOwnerId());
        lodge.setName(dto.getName());
        lodge.setAddress(dto.getAddress());
        lodge.setLatitude(dto.getLatitude());
        lodge.setLongitude(dto.getLongitude());
        lodge.setDescription(dto.getDescription());
        lodge.setVerified(dto.isVerified());
        return lodge;
    }

    public LodgeResponseDTO toObject(Lodge entity) {
        LodgeResponseDTO dto = new LodgeResponseDTO();
        dto.setId(entity.getId());
        dto.setOwnerId(entity.getOwnerId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setDescription(entity.getDescription());
        dto.setVerified(entity.isVerified());
        return dto;
    }


    // List<Entity> → List<DTO>
    public List<LodgeResponseDTO> toDtoList(List<Lodge> entities) {
        return entities.stream()
                .map(this::toObject)
                .collect(Collectors.toList());
    }
}
