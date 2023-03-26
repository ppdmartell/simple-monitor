package simplemonitor.microservice.application.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simplemonitor.microservice.application.dto.CategoryDto;

@RestController
@RequestMapping("/api/category")
public class ApplicationController {
	
	@PostMapping("/application")
	public ResponseEntity<String> receiveCategoryDto(@Valid @RequestBody CategoryDto categoryDto) {
		return ResponseEntity.ok(categoryDto.toString());
	}

}
