package com.lodgeservice.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lodges")
public class Lodge {

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

    // getters and setters
}
