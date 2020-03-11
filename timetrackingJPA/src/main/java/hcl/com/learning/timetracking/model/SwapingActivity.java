package hcl.com.learning.timetracking.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class SwapingActivity {
	
	public SwapingActivity() {
		
	}
	
	@NotBlank(message = "employee activity should not be blank")
	private String swapActivity;
	
	private Date swipeDateTime;
		
	
	@NotBlank(message = "employee location should not be blank")
	private String location;

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

	
	

}
