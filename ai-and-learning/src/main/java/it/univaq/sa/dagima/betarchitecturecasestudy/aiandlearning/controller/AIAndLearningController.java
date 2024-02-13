package it.univaq.sa.dagima.betarchitecturecasestudy.aiandlearning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIAndLearningController {
	
	@GetMapping("/")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
	}
}
