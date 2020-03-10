package hcl.com.learning.timetracking.service;

import hcl.com.learning.timetracking.model.Employee;
import hcl.com.learning.timetracking.model.EmployeeActivity;

public interface EmployeeService {
	
    public int save(Employee employee );
	public Employee retrieveEmployeeById(Long employeeId );
	public int saveEmployeeActivity(EmployeeActivity employeeActivity);

}
