package com.hcl.flight.flightreservation.dto;

public class PassengerDTO {
	
	private String firstName;
    private String lastName;
    private Long age;
    private String gender;
    private String mealPreferences;
    
    
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
