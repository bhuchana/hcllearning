package hcl.com.learning.timetracking.model;

public class UserRoleDTO {
	
	private String role;
	private Integer count;
	public UserRoleDTO(String role, Integer count) {
		super();
		this.role = role;
		this.count = count;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	

}
