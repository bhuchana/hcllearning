package com.hcl.flight.flightreservation.dto;

import java.util.List;

public class ReservationRequest {
	
	private List<PassengerDTO> list;

	public List<PassengerDTO> getList() {
		return list;
	}

	public void setList(List<PassengerDTO> list) {
		this.list = list;
	}

}
