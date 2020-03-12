package com.hcl.flight.flightreservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="passengerid")
	private Long id;

	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
    private String lastName;
	
	@Column(name="age")
    private Long age;
    
	@Column(name="gender")
    private String gender;
    
    @Column(name="meal")
    private String mealPreferences;
   
    
    public Passenger() {
    	
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

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMealPreferences() {
		return mealPreferences;
	}

	public void setMealPreferences(String mealPreferences) {
		this.mealPreferences = mealPreferences;
	}

	
}
