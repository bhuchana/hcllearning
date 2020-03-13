package com.hcl.flight.flightreservation.service;

import java.util.Date;
import java.util.List;

import com.hcl.flight.flightreservation.dto.BookingHistory;
import com.hcl.flight.flightreservation.dto.ReservationRequest;
import com.hcl.flight.flightreservation.entity.Airline;

public interface AirlinesService {
	
	public Airline save(Airline airline);
	public List<Airline> findAirlines(String source,String destination, Date dateReceived);
	public String createReservation(Long userId,Long airlineId,ReservationRequest reservationRequest);
	public List<BookingHistory> findAllBookingHistory(Long usedId, Date fromDate, Date toDate);
	public String removeAirlineById(Long airlineId);
}
