package com.hcl.flight.flightreservation.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.flight.flightreservation.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String createUser(User user) {
		 sessionFactory.getCurrentSession().persist(user);
		 return "user added";
		
	}

	@Override
	public List<User> getUsers() {	
		return   sessionFactory.getCurrentSession().
				createQuery("from User",User.class).list();
	}

}
