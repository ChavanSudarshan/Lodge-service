package com.lodgeservice.service;

import javax.validation.Valid;

import com.lodgeservice.dtos.LodgeCreationDTO;
import com.lodgeservice.dtos.LodgeResponseDTO;

public interface LodgeService {

	//public LodgeCreationDTO saveLodge(LodgeCreationDTO dto);
	
	public LodgeResponseDTO saveLodge(LodgeCreationDTO dto);
	
	
	public LodgeResponseDTO getLodgeById(String id);
	
	public LodgeResponseDTO updateLodge(String id, @Valid LodgeCreationDTO dto);

	public void deleteLodge(String id);
}
