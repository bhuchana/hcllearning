package com.hcl.flight.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.flightreservation.dao.UserRepository;
import com.hcl.flight.flightreservation.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) throws RuntimeException {
		return userRepository.save(user);
	}

	
    

}
