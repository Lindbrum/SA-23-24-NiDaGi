package it.univaq.sa.dagima.betarchitecturecasestudy.attractionreview.model;

public class AttractionReview {
	
	private int id;
	
	private int userId;
	
	private int attractionId;
	
	private int rating;
	
	private String body;

	public AttractionReview() {}
	
	public AttractionReview(int id, int attractionId, int userId, int rating, String body) {
		super();
		this.id = id;
		this.attractionId = attractionId;
		this.userId = userId;
		this.rating = rating;
		this.body = body;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
