package hcl.com.learning.timetracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcl.com.learning.timetracking.model.Employee;
import hcl.com.learning.timetracking.model.EmployeeActivity;
import hcl.com.learning.timetracking.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public int save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee retrieveEmployeeById(Long employeeId) {
		return employeeDao.retrieveEmployeeById(employeeId);
	}

	@Override
	public int saveEmployeeActivity(EmployeeActivity employeeActivity) {
		return employeeDao.saveEmployeeActivity(employeeActivity);
	}
	
    

}
