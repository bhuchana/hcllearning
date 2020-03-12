package com.hcl.flight.flightreservation.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.flight.flightreservation.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
