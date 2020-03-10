package hcl.com.learning.timetracking.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeActivity {
	
	@NotBlank
	private String swapActivity;
	@NotNull
	private Long employeeActivityId;
	
	private Date swipeDateTime;
	@NotNull
    private Long employeeId;
	
	
	private String firstName;
	
	
	private String lastName;
		
	
	private String location;
	
	
	public Long getEmployeeActivityId() {
		return employeeActivityId;
	}
	public void setEmployeeActivityId(Long employeeActivityId) {
		this.employeeActivityId = employeeActivityId;
	}
	public Date getSwipeDateTime() {
		return swipeDateTime;
	}
	public void setSwipeDateTime(Date swipeDateTime) {
		this.swipeDateTime = swipeDateTime;
	}
	public String getSwapActivity() {
		return swapActivity;
	}
	public void setSwapActivity(String swapActivity) {
		this.swapActivity = swapActivity;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}	

}
