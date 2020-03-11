package hcl.com.learning.timetracking.service;

import java.util.List;

import hcl.com.learning.timetracking.model.Employee;
import hcl.com.learning.timetracking.model.EmployeeActivity;
import hcl.com.learning.timetracking.model.UserRoleDTO;
import hcl.com.learning.timetracking.model.SwapingActivity;

public interface EmployeeService {
	
    public Employee save(Employee employee );
	public EmployeeActivity saveEmployeeActivity(SwapingActivity employeeActivity, Long employeeId);
	public List<UserRoleDTO> getUserRoles();
	

}
