package com.hcl.flight.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flight.flightreservation.entity.User;
import com.hcl.flight.flightreservation.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		 User savedUser = userService.save(user);
		if(savedUser!=null) {
			return new ResponseEntity<User>(savedUser, HttpStatus.OK);
		}
		throw new RuntimeException("Error while creating record");
		
	}

}
