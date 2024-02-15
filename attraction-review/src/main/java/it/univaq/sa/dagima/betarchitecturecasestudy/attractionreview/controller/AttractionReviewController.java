package it.univaq.sa.dagima.betarchitecturecasestudy.attractionreview.controller;

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

import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreview.model.AddReviewPayload;
import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreview.model.AttractionReview;

@RestController
@RequestMapping("/reviews")
public class AttractionReviewController {
	
	private List<AttractionReview> reviews = new ArrayList<>();
	private static int currID = 0;
	
	public AttractionReviewController() {
		//hardcoded data
		reviews.addAll(List.of(
				new AttractionReview(currID++, 0, 0, 5, "This is a review from user 0 on attraction 0."),
				new AttractionReview(currID++, 0, 1, 4, "This is a review from user 0 on attraction 1."),
				new AttractionReview(currID++, 0, 2, 5, "This is a review from user 0 on attraction 2."),
				new AttractionReview(currID++, 0, 3, 5, "This is a review from user 0 on attraction 3."),
				new AttractionReview(currID++, 0, 4, 5, "This is a review from user 0 on attraction 4."),
				new AttractionReview(currID++, 1, 0, 5, "This is a review from user 1 on attraction 0."),
				new AttractionReview(currID++, 1, 1, 5, "This is a review from user 1 on attraction 1."),
				new AttractionReview(currID++, 1, 2, 5, "This is a review from user 1 on attraction 2."),
				new AttractionReview(currID++, 1, 3, 5, "This is a review from user 1 on attraction 3."),
				new AttractionReview(currID++, 1, 4, 5, "This is a review from user 1 on attraction 4.")
		));
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<AttractionReview>> getAll() {
		
		//TODO add call to data processing
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	
	@GetMapping("/{target}/{id}")
	public ResponseEntity<List<AttractionReview>> getReviews(@PathVariable(value = "target") String target, @PathVariable(value = "id") Integer id){
		List<AttractionReview> result = new ArrayList<>();
		if("attraction".equals(target)) {
			for(AttractionReview ar : reviews) {
				if(ar.getAttractionId() == id) {
					result.add(ar);
				}
			}
		}else if("user".equals(target)){
			for(AttractionReview ar : reviews) {
				if(ar.getUserId() == id) {
					result.add(ar);
				}
			}
		}else {
			throw new IllegalArgumentException("Invalid target property: must be either \"user\" or \"attraction\"");
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/add/{id}")
	public ResponseEntity<String> getReviews(@PathVariable(value = "id") Integer id, @RequestBody() AddReviewPayload review){

		reviews.add(new AttractionReview(currID++, id, review.userId(), review.rating(), review.body()));
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
