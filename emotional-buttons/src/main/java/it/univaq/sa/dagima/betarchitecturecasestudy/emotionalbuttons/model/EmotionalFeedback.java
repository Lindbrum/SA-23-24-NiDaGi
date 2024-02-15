package it.univaq.sa.dagima.betarchitecturecasestudy.emotionalbuttons.model;

import java.time.LocalDateTime;

public class EmotionalFeedback {
	
	private int id;
	
	private int userId;
	
	private int attractionId;
	
	private int rating;
	
	private LocalDateTime timestamp;

	public EmotionalFeedback() {}
	
	public EmotionalFeedback(int id, int attractionId, int userId, int rating, LocalDateTime timestamp) {
		this.id = id;
		this.attractionId = attractionId;
		this.userId = userId;
		this.rating = rating;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(int attractionId) {
		this.attractionId = attractionId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
