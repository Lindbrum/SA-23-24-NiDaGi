package it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model.Attraction;
import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model.AttractionReservation;
import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model.ReservationPayload;
import it.univaq.sa.dagima.betarchitecturecasestudy.attractionreservation.model.TimeSlot;

@RestController
@RequestMapping("/reservations")
public class AttractionReservationController {
	private List<AttractionReservation> reservations = new ArrayList<>();
	private static int currResID = 0;
	
	private List<Attraction> attractions = new ArrayList<>();
	private static int currAttrID = 0;
	
	private List<TimeSlot> timeSlots = new ArrayList<>();
	private static int currSlotID = 0;
	
	public AttractionReservationController() {
		attractions.addAll(List.of(
				new Attraction(currAttrID++, "Rollercoaster", true, 30, 0, 0), 
				new Attraction(currAttrID++, "Tower", true, 20, 15, 5),
				new Attraction(currAttrID++, "Tagadà", true, 40, 130, 15),
				new Attraction(currAttrID++, "Hammer", true, 30, 60, 10),
				new Attraction(currAttrID++, "Crash cars", true, 20, 2, 3))
		);
		timeSlots.addAll(List.of(
				new TimeSlot(currSlotID++, 0, LocalTime.of(8, 0), LocalTime.of(8, 10), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(8, 10), LocalTime.of(8, 20), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(8, 20), LocalTime.of(8, 30), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(8, 30), LocalTime.of(8, 40), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(8, 40), LocalTime.of(8, 50), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(8, 50), LocalTime.of(9, 0), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(9, 0), LocalTime.of(9, 10), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(9, 10), LocalTime.of(9, 20), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(9, 20), LocalTime.of(9, 30), 30),
				new TimeSlot(currSlotID++, 0, LocalTime.of(9, 30), LocalTime.of(9, 40), 30)
		));
		
		timeSlots.addAll(
				List.of(
						new TimeSlot(currSlotID++, 1, LocalTime.of(8, 0), LocalTime.of(8, 10), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(8, 10), LocalTime.of(8, 20), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(8, 20), LocalTime.of(8, 30), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(8, 30), LocalTime.of(8, 40), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(8, 40), LocalTime.of(8, 50), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(8, 50), LocalTime.of(9, 0), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(9, 0), LocalTime.of(9, 10), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(9, 10), LocalTime.of(9, 20), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(9, 20), LocalTime.of(9, 30), 20),
						new TimeSlot(currSlotID++, 1, LocalTime.of(9, 30), LocalTime.of(9, 40), 20)
				));
		timeSlots.addAll(
				List.of(
						new TimeSlot(currSlotID++, 2, LocalTime.of(8, 0), LocalTime.of(8, 10), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(8, 10), LocalTime.of(8, 20), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(8, 20), LocalTime.of(8, 30), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(8, 30), LocalTime.of(8, 40), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(8, 40), LocalTime.of(8, 50), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(8, 50), LocalTime.of(9, 0), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(9, 0), LocalTime.of(9, 10), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(9, 10), LocalTime.of(9, 20), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(9, 20), LocalTime.of(9, 30), 40),
						new TimeSlot(currSlotID++, 2, LocalTime.of(9, 30), LocalTime.of(9, 40), 40)
				));
		timeSlots.addAll(
				List.of(
						new TimeSlot(currSlotID++, 3, LocalTime.of(8, 0), LocalTime.of(8, 10), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(8, 10), LocalTime.of(8, 20), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(8, 20), LocalTime.of(8, 30), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(8, 30), LocalTime.of(8, 40), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(8, 40), LocalTime.of(8, 50), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(8, 50), LocalTime.of(9, 0), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(9, 0), LocalTime.of(9, 10), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(9, 10), LocalTime.of(9, 20), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(9, 20), LocalTime.of(9, 30), 30),
						new TimeSlot(currSlotID++, 3, LocalTime.of(9, 30), LocalTime.of(9, 40), 30)
				));
		timeSlots.addAll(
				List.of(
						new TimeSlot(currSlotID++, 4, LocalTime.of(8, 0), LocalTime.of(8, 10), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(8, 10), LocalTime.of(8, 20), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(8, 20), LocalTime.of(8, 30), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(8, 30), LocalTime.of(8, 40), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(8, 40), LocalTime.of(8, 50), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(8, 50), LocalTime.of(9, 0), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(9, 0), LocalTime.of(9, 10), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(9, 10), LocalTime.of(9, 20), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(9, 20), LocalTime.of(9, 30), 20),
						new TimeSlot(currSlotID++, 4, LocalTime.of(9, 30), LocalTime.of(9, 40), 20)
				));
		timeSlots.addAll(List.of(
				new TimeSlot(currSlotID++, 0, LocalTime.of(15, 0), LocalTime.of(15, 10), 30),
				new TimeSlot(currSlotID++, 1, LocalTime.of(15, 0), LocalTime.of(15, 10), 20),
				new TimeSlot(currSlotID++, 2, LocalTime.of(15, 0), LocalTime.of(15, 10), 40),
				new TimeSlot(currSlotID++, 3, LocalTime.of(15, 0), LocalTime.of(15, 10), 30),
				new TimeSlot(currSlotID++, 4, LocalTime.of(15, 0), LocalTime.of(15, 10), 20)
				));
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Attraction>> getAttractions() {
		
		//TODO add call to data processing
		return new ResponseEntity<>(attractions, HttpStatus.OK);
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
	public ResponseEntity<String> registerReservation(@PathVariable(value = "id") Integer id, @RequestBody() ReservationPayload reservation){
		//parse into LocalTime
		String attractionName="";
		LocalTime slotStart = LocalTime.parse(reservation.slotStart(), DateTimeFormatter.ofPattern("H:mm:ss"));
		for(Attraction n: attractions ){
			if(n.getId()==id){
				attractionName=n.getName();

				break;
			}

		}
		for(TimeSlot t : timeSlots) {
			if(t.getAttractionId() == id && t.getStart().equals(slotStart)) {
				t.setAvailability(t.getAvailability() - 1);
				reservations.add(new AttractionReservation(currResID++, id, reservation.userId(), slotStart, LocalDateTime.now(), attractionName));
				break;
			}
		}
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@GetMapping("/history/{user}")
	public ResponseEntity<List<AttractionReservation>> getUserHistory(@PathVariable(value = "user") Integer userId){
		List<AttractionReservation> result = new ArrayList<>();
		for(AttractionReservation r : reservations) {
			if(r.getUserId() == userId) {
				result.add(r);
			}
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/history/{user}/future")
	public ResponseEntity<List<AttractionReservation>> getUserFutureReservations(@PathVariable(value = "user") Integer userId){
		List<AttractionReservation> result = new ArrayList<>();
		for(AttractionReservation r : reservations) {
			if(r.getUserId() == userId 
					&& !r.getTimestamp().toLocalDate().isBefore(LocalDate.now()) 
					&& r.getSlotStart().isAfter(LocalTime.now())) {
				result.add(r);
			}
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/history/{user}/past")
	public ResponseEntity<List<AttractionReservation>> getUserPastReservations(@PathVariable(value = "user") Integer userId){
		List<AttractionReservation> result = new ArrayList<>();
		for(AttractionReservation r : reservations) {
			if(r.getUserId() == userId 
					&& (r.getTimestamp().toLocalDate().isBefore(LocalDate.now()) || r.getSlotStart().isBefore(LocalTime.now()))
					) {
				result.add(r);
			}
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
