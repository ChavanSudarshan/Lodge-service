package com.lodgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LodgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LodgeApplication.class, args);
		System.out.println("LodgeApplication Service is in the running...");
	}
}
