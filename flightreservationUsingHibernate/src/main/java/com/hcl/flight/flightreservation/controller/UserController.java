package com.hcl.flight.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<String> createUser(@RequestBody User user){
		 String message= userService.createUser(user);
		if(message!=null) {
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		throw new RuntimeException("Error while creating record");
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getUsers(){
		List<User> users = userService.getUsers();
		if(!users.isEmpty()) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
		throw new RuntimeException("Error while getting users record");
		
	}

}
