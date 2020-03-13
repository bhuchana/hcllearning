package com.hcl.flight.flightreservation.dto;

import java.util.List;

public class BookingHistory {
	
	private List<PassengerDTO> passengerDTOs;

	public List<PassengerDTO> getPassengerDTOs() {
		return passengerDTOs;
	}

	public void setPassengerDTOs(List<PassengerDTO> passengerDTOs) {
		this.passengerDTOs = passengerDTOs;
	}
	
	

}
