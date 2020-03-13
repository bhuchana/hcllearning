package com.hcl.flight.flightreservation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="USER")
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	private Long id;
	
	@NotBlank
	@Size(min=2, message="First Name should have atleast 2 characters")
	@Column(name="firstname")
	private String firstName;
	
	@NotBlank
	@Size(min=2, message="last Name should have atleast 2 characters")
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="username",unique = true)
	private String userName;
	
	@OneToMany(mappedBy = "user")
	private List<UserBooking> userBookings; 

	public User() {
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserBooking> getUserBookings() {
		return userBookings;
	}

	public void setUserBookings(List<UserBooking> userBookings) {
		this.userBookings = userBookings;
	}
	
}
