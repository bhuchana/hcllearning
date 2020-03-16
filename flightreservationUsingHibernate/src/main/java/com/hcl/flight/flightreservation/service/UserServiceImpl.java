package com.hcl.flight.flightreservation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.flightreservation.dao.UserDAO;
import com.hcl.flight.flightreservation.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO dao;

	@Override
	@Transactional
	public String createUser(User user) {
		// TODO Auto-generated method stub
		return dao.createUser(user);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return dao.getUsers();
	}
	
	
	
    

}
