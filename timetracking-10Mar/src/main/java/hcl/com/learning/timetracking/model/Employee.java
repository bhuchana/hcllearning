package hcl.com.learning.timetracking.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

	@NotNull
	private Long employeeId;
	
	@NotBlank
	@Size(min=2, message="First Name should have atleast 2 characters")
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String role;
		
	@NotBlank
	private String location;
	public Employee() {
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

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [id=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", designation="
				+ getRole() + ", location=" + location + "]";
	}



	public Long getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	

	

}
