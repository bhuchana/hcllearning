package com.hcl.flight.flightreservation.dao;

import java.util.List;
import java.util.Optional;

import com.hcl.flight.flightreservation.entity.User;

public interface UserDAO {
	
	String createUser(User user);
	 List<User> getUsers();

}
