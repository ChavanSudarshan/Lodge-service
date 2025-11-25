package com.lodgeservice.dtos;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class LodgeCreationDTO {

	@Id
    private String id; // UUID

    private String ownerId; // comes from auth-service

    private String name;

    private String address;

    private Double latitude;

    private Double longitude;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean verified = false;

    private Instant createdAt = Instant.now();
}
