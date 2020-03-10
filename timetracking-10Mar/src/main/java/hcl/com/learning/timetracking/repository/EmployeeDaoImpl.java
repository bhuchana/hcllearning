package hcl.com.learning.timetracking.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hcl.com.learning.timetracking.exception.EmployeeNotFoundException;
import hcl.com.learning.timetracking.model.Employee;
import hcl.com.learning.timetracking.model.EmployeeActivity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao  {
	
	

	@Autowired
	JdbcTemplate jdbcTemplate;
	static final String INSERT_EMPLOYEE="insert into bchandan.employee(employee_id,designation,firstName,lastName,location)values(?,?,?,?,?)";
	static final String GET_EMPLOYEE = "SELECT * FROM employee WHERE employee_id = ?";
	static final String INSERT_EMPLOYEE_ACTIVITY="insert into bchandan.employee_activity(employee_activity_id,swipeDateTime,isSwap,employee_id)values(?,?,?,?)";
	
	@Override
	public int save(Employee employee) {
		int rowsUpdated = jdbcTemplate.update(INSERT_EMPLOYEE, employee.getEmployeeId(),employee.getRole(),employee.getFirstName(),employee.getLastName(),employee.getLocation());
		return rowsUpdated;
	}

	@Override
	public Employee retrieveEmployeeById(Long id) throws EmployeeNotFoundException {
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee=null;
		try {
			employee = jdbcTemplate.queryForObject(GET_EMPLOYEE, rowMapper, id);
		}
		catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found in dao "+id);
		} 
		System.out.println("employee in dao layer");
		return employee;
				
	}

	@Override
	public int saveEmployeeActivity(EmployeeActivity employeeActivity) {
		int rowsUpdated = jdbcTemplate.update(INSERT_EMPLOYEE_ACTIVITY, employeeActivity.getEmployeeActivityId(),new Date(),employeeActivity.getSwapActivity(),employeeActivity.getEmployeeId());
		return rowsUpdated;
		
	}
	
	

}
