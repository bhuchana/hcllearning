package hcl.com.web.learning.model;

import java.util.Date;

public class Employee  {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date swipeinTime;
	
	private Date swipeoutTime;

	public Employee() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

	public Date getSwipeinTime() {
		return swipeinTime;
	}

	public void setSwipeinTime(Date swipeinTime) {
		this.swipeinTime = swipeinTime;
	}

	public Date getSwipeoutTime() {
		return swipeoutTime;
	}

	public void setSwipeoutTime(Date swipeoutTime) {
		this.swipeoutTime = swipeoutTime;
	}
}