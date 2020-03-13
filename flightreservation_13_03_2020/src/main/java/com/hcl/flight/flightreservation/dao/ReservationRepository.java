package com.hcl.flight.flightreservation.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.flight.flightreservation.entity.UserBooking;

public interface ReservationRepository extends CrudRepository<UserBooking, Long> {

}
