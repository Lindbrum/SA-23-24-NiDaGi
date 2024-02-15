package it.univaq.sa.dagima.betarchitecturecasestudy.emotionalbuttons.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.sa.dagima.betarchitecturecasestudy.emotionalbuttons.model.AddFeedbackPayload;
import it.univaq.sa.dagima.betarchitecturecasestudy.emotionalbuttons.model.EmotionalFeedback;

@RestController
@RequestMapping("/emotional-buttons")
public class EmotionalButtonsController {
	
	private List<EmotionalFeedback> feedbacks = new ArrayList<>();
	private static int currID = 0;
	
	public EmotionalButtonsController() {
		feedbacks.addAll(List.of(
				new EmotionalFeedback(currID++, 0, 0, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 0, 1, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 0, 2, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 0, 3, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 0, 4, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 1, 0, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 1, 1, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 1, 2, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 1, 3, 3, LocalDateTime.now()),
				new EmotionalFeedback(currID++, 1, 4, 3, LocalDateTime.now())
		));
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmotionalFeedback>> getAll() {
		
		//TODO add call to data processing
		return new ResponseEntity<>(feedbacks, HttpStatus.OK);
	}
	
	@GetMapping("/{target}/{id}")
	public ResponseEntity<List<EmotionalFeedback>> getFeedbacks(@PathVariable(value = "target") String target, @PathVariable(value = "id") Integer id){
		List<EmotionalFeedback> result = new ArrayList<>();
		if("attraction".equals(target)) {
			for(EmotionalFeedback ef : feedbacks) {
				if(ef.getAttractionId() == id) {
					result.add(ef);
				}
			}
		}else if("user".equals(target)){
			for(EmotionalFeedback ef : feedbacks) {
				if(ef.getUserId() == id) {
					result.add(ef);
				}
			}
		}else {
			throw new IllegalArgumentException("Invalid target property: must be either \"user\" or \"attraction\"");
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/add/{id}")
	public ResponseEntity<String> addFeedback(@PathVariable(value = "id") Integer id, @RequestBody() AddFeedbackPayload review){

		feedbacks.add(new EmotionalFeedback(currID++, id, review.userId(), review.rating(), LocalDateTime.now()));
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
