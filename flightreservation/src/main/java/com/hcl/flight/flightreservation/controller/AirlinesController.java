package com.hcl.flight.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flight.flightreservation.dto.ReservationRequest;
import com.hcl.flight.flightreservation.entity.Airline;
import com.hcl.flight.flightreservation.service.AirlinesService;

@RestController
public class AirlinesController {

	@Autowired
	private AirlinesService airlinesService;
	
	@PostMapping("/airlines")
	public ResponseEntity<Airline> createAirline(@RequestBody Airline airline){
		 Airline airlineSaved = airlinesService.save(airline);
		if(airlineSaved!=null) {
			return new ResponseEntity<Airline>(airlineSaved, HttpStatus.OK);
		}
		throw new RuntimeException("Error while creating record");
		
	}
	
	@GetMapping("/airlines")
	public List<Airline> searchFlights(@RequestParam("source") String source,
			                    @RequestParam("destination") String destination) {
		
		return airlinesService.findAirlines(source, destination);
		
	}
	
	@PostMapping("/booking/{userId}/{airlineId}")
	public String createReservation(@PathVariable Long userId, @PathVariable Long airlineId,  @RequestBody ReservationRequest reservationRequest) {
		return airlinesService.createReservation(userId, airlineId, reservationRequest);
		
		
	}
}
