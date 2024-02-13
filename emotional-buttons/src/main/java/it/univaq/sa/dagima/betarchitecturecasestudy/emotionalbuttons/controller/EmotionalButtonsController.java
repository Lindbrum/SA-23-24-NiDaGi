package it.univaq.sa.dagima.betarchitecturecasestudy.emotionalbuttons.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emotional-buttons")
public class EmotionalButtonsController {
	
	@GetMapping
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
	}
}
