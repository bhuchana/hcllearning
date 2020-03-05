package hcl.com.learning.timetracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hcl.com.learning.timetracking.model.Employee;
import hcl.com.learning.timetracking.model.EmployeeActivity;
import hcl.com.learning.timetracking.service.EmployeeService;

@RestController
public class EmployeeController {
   
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/test")
	public String  testConnection() {
		
		
		return "hello";
	}
	
	@PostMapping("/employees")
	public ResponseEntity<?>  saveEmployee(@RequestBody Employee employee) {
		int rowsUpdated = employeeService.save(employee);
		if(rowsUpdated>0) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		throw new RuntimeException("Error while creating record");
		
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee>  getEmployee(@PathVariable Long id) {
		
		return new ResponseEntity<Employee>(employeeService.retrieveEmployeeById(id),HttpStatus.OK);
	}
	
	@PostMapping("/employees/activity")
	public ResponseEntity<?>  saveEmployeeActivity(@RequestBody EmployeeActivity employeeActivity) {
		
		int rowsUpdated = employeeService.saveEmployeeActivity(employeeActivity);
		if(rowsUpdated>0) {
			return new ResponseEntity<EmployeeActivity>(employeeActivity, HttpStatus.OK);
		}
		throw new RuntimeException("Error while creating record");
		
	}
	
	
}
