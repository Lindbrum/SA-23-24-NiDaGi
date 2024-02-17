package it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttractionReservation {

	private int id;
	private int attractionId;
	private String name;
	private int userId;
	private LocalTime slotStart;
	private LocalDateTime timestamp;
	
	public AttractionReservation() {}
	
	public AttractionReservation(int id, int attractionId, int userId, LocalTime slotStart, LocalDateTime timestamp, String name) {
		this.id = id;
		this.attractionId = attractionId;
		this.name=name;
		this.userId = userId;
		this.slotStart = slotStart;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttractionName() {
		return name;
	}

	public void setAttractionName(String name) {
		this.name = name;
	}

	public int getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(int attractionId) {
		this.attractionId = attractionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalTime getSlotStart() {
		return slotStart;
	}

	public void setSlotStart(LocalTime slotStart) {
		this.slotStart = slotStart;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
