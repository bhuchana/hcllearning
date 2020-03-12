package com.hcl.flight.flightreservation.service;

import java.util.List;

import com.hcl.flight.flightreservation.dto.ReservationRequest;
import com.hcl.flight.flightreservation.entity.Airline;

public interface AirlinesService {
	
	public Airline save(Airline airline);
	public List<Airline> findAirlines(String source,String destination);
	public String createReservation(Long userId,Long airlineId,ReservationRequest reservationRequest);
}
