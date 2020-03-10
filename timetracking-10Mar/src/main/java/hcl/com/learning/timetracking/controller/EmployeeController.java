package hcl.com.learning.timetracking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcl.com.learning.timetracking.exception.EmployeeNotFoundException;
import hcl.com.learning.timetracking.model.Employee;
import hcl.com.learning.timetracking.model.EmployeeActivity;
import hcl.com.learning.timetracking.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
   
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/employees")
	public ResponseEntity<?>  saveEmployee(@Valid @RequestBody Employee employee) {
		int rowsUpdated = employeeService.save(employee);
		if(rowsUpdated>0) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		throw new RuntimeException("Error while creating record");
		
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee>  getEmployee(@PathVariable Long id){

		Employee employee = employeeService.retrieveEmployeeById(id);
	 if(employee!=null) {
		return new ResponseEntity<Employee>(employeeService.retrieveEmployeeById(id),HttpStatus.OK);
	} else {
		throw new EmployeeNotFoundException("Employee not found for Id "+id);
	  }
	}
	
	@PostMapping("/employees/activity")
	public ResponseEntity<?>  saveEmployeeActivity(@Valid @RequestBody EmployeeActivity employeeActivity) {
		
		int rowsUpdated = employeeService.saveEmployeeActivity(employeeActivity);
		if(rowsUpdated>0) {
			return new ResponseEntity<String>("Employee activity Inserted", HttpStatus.OK);
		}
		throw new RuntimeException("Error while creating record");
		
	}
	
	
}
