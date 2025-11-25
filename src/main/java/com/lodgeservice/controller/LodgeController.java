package com.lodgeservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lodgeservice.dtos.LodgeCreationDTO;
import com.lodgeservice.dtos.LodgeResponseDTO;
import com.lodgeservice.service.LodgeServiceImpl;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/lodge")
public class LodgeController {

	@Autowired
	LodgeServiceImpl service;
	
	@GetMapping("/test")
	public String testLodgeService() {
		log.info("Hello");
		return "Lodge Service Tested Successfully....!!!";
	}
	
	@PostMapping("/save")
	public ResponseEntity<LodgeResponseDTO> saveLodge(@RequestBody LodgeCreationDTO dto) {
	    log.info("Saving lodge: {}", dto.getName());

	    LodgeResponseDTO response = service.saveLodge(dto);

	    return ResponseEntity
	    		.status(HttpStatus.CREATED)   // return 201 Created
	            .body(response);              // send the created resource
	}

	@GetMapping("/{id}")
	public ResponseEntity<LodgeResponseDTO> getLodgeById(@PathVariable String id) {
	    log.info("Fetching lodge with ID: {}", id);

	    LodgeResponseDTO response = service.getLodgeById(id);

	    return ResponseEntity.ok(response); // 200 OK
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<LodgeResponseDTO> getLodgeByName(@PathVariable String name){
		
		log.info("Fetching lodge with Name: {}", name);
		
		LodgeResponseDTO response = service.getLodgeByName(name);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<LodgeResponseDTO> updateLodge(
	        @PathVariable String id,
	        @RequestBody @Valid LodgeCreationDTO dto) {

	    log.info("Updating lodge {} with data: {}", id, dto.getName());
	    LodgeResponseDTO updated = service.updateLodge(id, dto);
	    return ResponseEntity.ok(updated);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLodge(@PathVariable String id) {
	    service.deleteLodge(id);
	    return ResponseEntity.noContent().build();
	}

	
}
