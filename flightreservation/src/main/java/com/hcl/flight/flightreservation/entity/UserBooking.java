package com.hcl.flight.flightreservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_booking")
public class UserBooking {
	
	public UserBooking() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookingid")
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User user; 
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "airlineid", nullable = false)
    private Airline airline;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passengerid", nullable = false)
    private Passenger passenger;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Airline getAirline() {
		return airline;
	}


	public void setAirline(Airline airline) {
		this.airline = airline;
	}


	public Passenger getPassenger() {
		return passenger;
	}


	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

		

}
