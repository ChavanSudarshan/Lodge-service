package com.lodgeservice.dtos;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LodgeResponseDTO {

	private String id;
    private String ownerId;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private String description;
    private boolean verified;
}
