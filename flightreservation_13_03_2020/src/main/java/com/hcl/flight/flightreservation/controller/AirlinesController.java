package com.hcl.flight.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flight.flightreservation.dto.BookingHistory;
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
			                    @RequestParam("destination") String destination,
			                    @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date dateReceived) {
		
		return airlinesService.findAirlines(source, destination,dateReceived);
		
	}
	
	@PostMapping("/booking/{userId}/{airlineId}")
	public String createReservation(@PathVariable Long userId, @PathVariable Long airlineId,  @RequestBody ReservationRequest reservationRequest) {
		return airlinesService.createReservation(userId, airlineId, reservationRequest);
		
		
	}
	
	
	@DeleteMapping("/airlines/{airlineId}")
	public String removeAirline(@PathVariable Long airlineId) {
		return airlinesService.removeAirlineById(airlineId);
		
		
	}
	
	@GetMapping("/booking/history")
	public List<BookingHistory> findAllBookingHistory(
			@RequestParam("userid") Long usedId,
            @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date fromDate,
            @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date toDate){
				
		airlinesService.findAllBookingHistory(usedId,fromDate,toDate);
		return null;
	}
	
	
	 
	
	
}
