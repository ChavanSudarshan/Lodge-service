package com.lodgeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lodge")
public class LodgeController {

	@GetMapping("/test")
	public String testLodgeService() {
		return "Lodge Service Tested Successfully....!!!";
	}
}
