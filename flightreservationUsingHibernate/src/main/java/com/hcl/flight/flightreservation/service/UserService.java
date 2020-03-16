package com.hcl.flight.flightreservation.service;

import java.util.List;

import com.hcl.flight.flightreservation.entity.User;

public interface UserService {
	
	String createUser(User user);
	List<User> getUsers();

}
