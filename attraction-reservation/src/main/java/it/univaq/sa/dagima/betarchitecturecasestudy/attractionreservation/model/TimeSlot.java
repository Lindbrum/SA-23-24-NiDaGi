package it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model;

import java.time.LocalTime;

public class TimeSlot {
	
	private int attractionId;
	
	private LocalTime start;
	
	private LocalTime end;
	
	private int availability;
	
	public TimeSlot() {}

	public TimeSlot(int attractionId, LocalTime start, LocalTime end, int availability) {
		super();
		this.attractionId = attractionId;
		this.start = start;
		this.end = end;
		this.availability = availability;
	}

	

	public int getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(int attractionId) {
		this.attractionId = attractionId;
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	
}
