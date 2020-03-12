package com.hcl.flight.flightreservation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hcl.flight.flightreservation.entity.Airline;

public interface AirlinesRepository extends CrudRepository<Airline, Long> {
	
	@Query("from Airline where source=:source and destination=:destination")
    List<Airline> findAirlines(@Param("source") String source,
    		                   @Param("destination") String destination);

}
