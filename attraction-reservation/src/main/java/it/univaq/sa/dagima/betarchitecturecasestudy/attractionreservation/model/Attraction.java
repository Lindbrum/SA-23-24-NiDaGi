package it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model;


public class Attraction {
	
	private Integer id;
	
	private String name;
	
	private boolean open;
	
	private int capacity;
	
	private int queueLength;
	
	private int queueMinutes;
	
	public Attraction() {}

	public Attraction(Integer id, String name, boolean open, int capacity, int queueLength, int queueMinutes) {
		this.id = id;
		this.name = name;
		this.open = open;
		this.capacity = capacity;
		this.queueLength = queueLength;
		this.queueMinutes = queueMinutes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getQueueLength() {
		return queueLength;
	}

	public void setQueueLength(int queueLength) {
		this.queueLength = queueLength;
	}

	public int getQueueMinutes() {
		return queueMinutes;
	}

	public void setQueueMinutes(int queueMinutes) {
		this.queueMinutes = queueMinutes;
	}
	
	
	
	
}
