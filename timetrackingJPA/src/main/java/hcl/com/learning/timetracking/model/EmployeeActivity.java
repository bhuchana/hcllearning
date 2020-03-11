package hcl.com.learning.timetracking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="employee_activity")
public class EmployeeActivity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_activity_id")
	private Long id;
	
	@NotBlank(message = "employee activity should not be blank")
	@Column(name="swap_activity")
	private String swapActivity;
	
	@Column(name="swipe_time")
	private Date swipeDateTime;
		
	@Column(name="location")
	@NotBlank(message = "employee location should not be blank")
	private String location;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
	
	public EmployeeActivity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSwapActivity() {
		return swapActivity;
	}

	public void setSwapActivity(String swapActivity) {
		this.swapActivity = swapActivity;
	}

	public Date getSwipeDateTime() {
		return swipeDateTime;
	}

	public void setSwipeDateTime(Date swipeDateTime) {
		this.swipeDateTime = swipeDateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
