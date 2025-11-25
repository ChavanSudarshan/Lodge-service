package com.lodgeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lodgeservice.dtos.LodgeCreationDTO;
import com.lodgeservice.entity.Lodge;

@Repository
public interface LodgeRepository extends JpaRepository<Lodge, String>{

	public LodgeCreationDTO save(LodgeCreationDTO dto);

	public Optional<Lodge> getLodgeByName(String name);
	
	public Optional<Lodge> findByNameContainingIgnoreCase(String name);

	
}


