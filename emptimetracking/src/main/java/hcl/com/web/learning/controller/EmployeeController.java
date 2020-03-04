package hcl.com.web.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcl.com.web.learning.model.Employee;
import hcl.com.web.learning.repository.EmployeeDao;

@RestController
@RequestMapping(value = "/employee-time-tracking", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;

	@PostMapping("/employees")
	Employee saveEmployee(@RequestBody Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
	
	

	
}