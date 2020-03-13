package com.hcl.flight.flightreservation.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.flight.flightreservation.entity.Passenger;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
	
	

}
