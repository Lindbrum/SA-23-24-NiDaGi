package it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model.Attraction;
import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model.Reservation;
import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model.TimeSlot;

@RestController
@RequestMapping("/reservations")
public class AttractionReservationController {
	
	private List<TimeSlot> timeSlots = new ArrayList<>();
	
	public AttractionReservationController() {
		timeSlots.addAll(List.of(
				new TimeSlot(0, LocalTime.of(8, 0), LocalTime.of(8, 10), 30),
				new TimeSlot(0, LocalTime.of(8, 10), LocalTime.of(8, 20), 30),
				new TimeSlot(0, LocalTime.of(8, 20), LocalTime.of(8, 30), 30),
				new TimeSlot(0, LocalTime.of(8, 30), LocalTime.of(8, 40), 30),
				new TimeSlot(0, LocalTime.of(8, 40), LocalTime.of(8, 50), 30),
				new TimeSlot(0, LocalTime.of(8, 50), LocalTime.of(9, 0), 30),
				new TimeSlot(0, LocalTime.of(9, 0), LocalTime.of(9, 10), 30),
				new TimeSlot(0, LocalTime.of(9, 10), LocalTime.of(9, 20), 30),
				new TimeSlot(0, LocalTime.of(9, 20), LocalTime.of(9, 30), 30),
				new TimeSlot(0, LocalTime.of(9, 30), LocalTime.of(9, 40), 30)
		));
		
		timeSlots.addAll(
				List.of(
						new TimeSlot(1, LocalTime.of(8, 0), LocalTime.of(8, 10), 20),
						new TimeSlot(1, LocalTime.of(8, 10), LocalTime.of(8, 20), 20),
						new TimeSlot(1, LocalTime.of(8, 20), LocalTime.of(8, 30), 20),
						new TimeSlot(1, LocalTime.of(8, 30), LocalTime.of(8, 40), 20),
						new TimeSlot(1, LocalTime.of(8, 40), LocalTime.of(8, 50), 20),
						new TimeSlot(1, LocalTime.of(8, 50), LocalTime.of(9, 0), 20),
						new TimeSlot(1, LocalTime.of(9, 0), LocalTime.of(9, 10), 20),
						new TimeSlot(1, LocalTime.of(9, 10), LocalTime.of(9, 20), 20),
						new TimeSlot(1, LocalTime.of(9, 20), LocalTime.of(9, 30), 20),
						new TimeSlot(1, LocalTime.of(9, 30), LocalTime.of(9, 40), 20)
				));
		timeSlots.addAll(
				List.of(
						new TimeSlot(2, LocalTime.of(8, 0), LocalTime.of(8, 10), 40),
						new TimeSlot(2, LocalTime.of(8, 10), LocalTime.of(8, 20), 40),
						new TimeSlot(2, LocalTime.of(8, 20), LocalTime.of(8, 30), 40),
						new TimeSlot(2, LocalTime.of(8, 30), LocalTime.of(8, 40), 40),
						new TimeSlot(2, LocalTime.of(8, 40), LocalTime.of(8, 50), 40),
						new TimeSlot(2, LocalTime.of(8, 50), LocalTime.of(9, 0), 40),
						new TimeSlot(2, LocalTime.of(9, 0), LocalTime.of(9, 10), 40),
						new TimeSlot(2, LocalTime.of(9, 10), LocalTime.of(9, 20), 40),
						new TimeSlot(2, LocalTime.of(9, 20), LocalTime.of(9, 30), 40),
						new TimeSlot(2, LocalTime.of(9, 30), LocalTime.of(9, 40), 40)
				));
		timeSlots.addAll(
				List.of(
						new TimeSlot(3, LocalTime.of(8, 0), LocalTime.of(8, 10), 30),
						new TimeSlot(3, LocalTime.of(8, 10), LocalTime.of(8, 20), 30),
						new TimeSlot(3, LocalTime.of(8, 20), LocalTime.of(8, 30), 30),
						new TimeSlot(3, LocalTime.of(8, 30), LocalTime.of(8, 40), 30),
						new TimeSlot(3, LocalTime.of(8, 40), LocalTime.of(8, 50), 30),
						new TimeSlot(3, LocalTime.of(8, 50), LocalTime.of(9, 0), 30),
						new TimeSlot(3, LocalTime.of(9, 0), LocalTime.of(9, 10), 30),
						new TimeSlot(3, LocalTime.of(9, 10), LocalTime.of(9, 20), 30),
						new TimeSlot(3, LocalTime.of(9, 20), LocalTime.of(9, 30), 30),
						new TimeSlot(3, LocalTime.of(9, 30), LocalTime.of(9, 40), 30)
				));
		timeSlots.addAll(
				List.of(
						new TimeSlot(4, LocalTime.of(8, 0), LocalTime.of(8, 10), 20),
						new TimeSlot(4, LocalTime.of(8, 10), LocalTime.of(8, 20), 20),
						new TimeSlot(4, LocalTime.of(8, 20), LocalTime.of(8, 30), 20),
						new TimeSlot(4, LocalTime.of(8, 30), LocalTime.of(8, 40), 20),
						new TimeSlot(4, LocalTime.of(8, 40), LocalTime.of(8, 50), 20),
						new TimeSlot(4, LocalTime.of(8, 50), LocalTime.of(9, 0), 20),
						new TimeSlot(4, LocalTime.of(9, 0), LocalTime.of(9, 10), 20),
						new TimeSlot(4, LocalTime.of(9, 10), LocalTime.of(9, 20), 20),
						new TimeSlot(4, LocalTime.of(9, 20), LocalTime.of(9, 30), 20),
						new TimeSlot(4, LocalTime.of(9, 30), LocalTime.of(9, 40), 20)
				));
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Attraction>> getAttractions() {
		
		List<Attraction> result = new ArrayList<>();
		result.addAll(List.of(
				new Attraction(0, "Rollercoaster", true, 30, 0, 0), 
				new Attraction(1, "Tower", true, 20, 15, 5),
				new Attraction(2, "Tagadà", true, 40, 130, 15),
				new Attraction(3, "Hammer", true, 30, 60, 10),
				new Attraction(4, "Crash cars", true, 20, 2, 3)));
		//TODO add call to data processing
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<TimeSlot>> getTimeSlots(@PathVariable(value = "id") Integer id){
		List<TimeSlot> result = new ArrayList<>();
		for(TimeSlot t : timeSlots) {
			if(t.getAttractionId() == id) {
				result.add(t);
			}
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> registerReservation(@PathVariable(value = "id") Integer id, @RequestBody() Reservation reservation){
		//parse into LocalTime
		LocalTime slotStart = LocalTime.parse(reservation.slotStart(), DateTimeFormatter.ofPattern("H:mm"));
		for(TimeSlot t : timeSlots) {
			if(t.getAttractionId() == id && t.getStart().equals(slotStart)) {
				t.setAvailability(t.getAvailability() - 1);
			}
		}
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
}
