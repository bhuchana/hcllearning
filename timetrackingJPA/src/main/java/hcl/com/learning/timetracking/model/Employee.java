package hcl.com.learning.timetracking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
	private Long id;
	
	@NotBlank
	@Size(min=2, message="First Name should have atleast 2 characters")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@Size(min=2, message="last Name should have atleast 2 characters")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "user role should not blank")
	@Column(name="user_role")
	private String userRole;
	
//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<EmployeeActivity> employeeActivities;
//		
	
	public Employee() {
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
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


//	public Set<EmployeeActivity> getEmployeeActivities() {
//		return employeeActivities;
//	}
//
//
//	public void setEmployeeActivities(Set<EmployeeActivity> employeeActivities) {
//		this.employeeActivities = employeeActivities;
//	}

	

}
