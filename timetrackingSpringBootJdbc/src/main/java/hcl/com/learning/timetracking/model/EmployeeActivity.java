package hcl.com.learning.timetracking.model;

import java.util.Date;

public class EmployeeActivity {
	
	private String swapActivity;
	private Long employeeActivityId;
	private Date swipeDateTime;
    private Long employeeId;
	
	
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
