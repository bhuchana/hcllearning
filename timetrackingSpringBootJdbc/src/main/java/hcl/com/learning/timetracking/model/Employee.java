package hcl.com.learning.timetracking.model;

import java.util.List;

public class Employee {

	private Long employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String designation;
	
	private List<EmployeeActivity> employeeActivities;
	
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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
				+ designation + ", location=" + location + "]";
	}



	public Long getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}



	public List<EmployeeActivity> getEmployeeActivities() {
		return employeeActivities;
	}



	public void setEmployeeActivities(List<EmployeeActivity> employeeActivities) {
		this.employeeActivities = employeeActivities;
	}

	

	

	

}
