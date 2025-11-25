package com.lodgeservice.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lodgeservice.dtos.LodgeCreationDTO;
import com.lodgeservice.dtos.LodgeResponseDTO;
import com.lodgeservice.entity.Lodge;
import com.lodgeservice.exception.ResourceNotFoundException;
import com.lodgeservice.mapper.LodgeMapper;
import com.lodgeservice.repository.LodgeRepository;

@Service
public class LodgeServiceImpl implements LodgeService{
	
	@Autowired
	LodgeRepository repository;
	
	@Autowired
	LodgeMapper mapper;
	
	void test() {
		System.out.println("Hello");
	}

	
	
	@Override
	public LodgeResponseDTO saveLodge(LodgeCreationDTO dto) {

	    // Convert DTO → Entity
	    Lodge lodge = mapper.toEntity(dto);

	    // Generate UUID BEFORE saving
	    lodge.setId(UUID.randomUUID().toString());

	    // Save to DB
	    Lodge savedLodge = repository.save(lodge);

	    // Convert Entity → ResponseDTO
	    return mapper.toObject(savedLodge);
	}

	
	@Override
	public LodgeResponseDTO getLodgeById(String id) {
	    Lodge lodge = repository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Lodge not found with id: " + id));

	    return mapper.toObject(lodge);
	}

	public LodgeResponseDTO getLodgeByName(String name) {
		
		Lodge lodge = repository.findByNameContainingIgnoreCase(name)
				.orElseThrow(() -> new ResourceNotFoundException("Lodge not found with Name: " + name));
		return mapper.toObject(lodge);
	}

	
	public LodgeResponseDTO updateLodge(String id, LodgeCreationDTO dto) {
	    Lodge existing = repository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Lodge not found with id: " + id));

	    // map fields from DTO to entity (only allowed fields)
	    existing.setName(dto.getName());
	    existing.setAddress(dto.getAddress());
	    existing.setLatitude(dto.getLatitude());
	    existing.setLongitude(dto.getLongitude());
	    existing.setDescription(dto.getDescription());
	    // optionally: existing.setVerified(dto.isVerified()); // only allow admin to change in prod

	    Lodge saved = repository.save(existing);
	    return mapper.toObject(saved); // ensures LodgeResponseDTO is returned
	}

	public void deleteLodge(String id) {
		Lodge lodge = repository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Lodge not found with id: " + id));
		    repository.delete(lodge);
	}


}
