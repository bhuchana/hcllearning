package com.hcl.flight.flightreservation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="airline")
public class Airline {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="airlineid")
	private Long id;
	
	@NotBlank(message = "airline number should not be blank")
	@Column(name="airlinenumber",unique = true)
	private String airlineNumber;
	
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="journeytime")
	@Temporal(TemporalType.DATE)
	private Date journeyTime;
	
	public Airline() {
		
	}
	

	@Override
	public String toString() {
		return "Airline [id=" + id + ", airlineNumber=" + airlineNumber + ", source=" + source + ", destination="
				+ destination + ", journeyTime=" + journeyTime + "]";
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirlineNumber() {
		return airlineNumber;
	}

	public void setAirlineNumber(String airlineNumber) {
		this.airlineNumber = airlineNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(Date journeyTime) {
		this.journeyTime = journeyTime;
	}
	
	
}
