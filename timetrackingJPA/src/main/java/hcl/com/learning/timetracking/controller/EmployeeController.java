package hcl.com.learning.timetracking.controller;

import java.util.List;

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

import hcl.com.learning.timetracking.model.Employee;
import hcl.com.learning.timetracking.model.EmployeeActivity;
import hcl.com.learning.timetracking.model.SwapingActivity;
import hcl.com.learning.timetracking.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
   
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/employees")
	public ResponseEntity<?>  saveEmployee(@Valid @RequestBody Employee employee) {
		Employee savedEmployee = employeeService.save(employee);
		if(savedEmployee!=null) {
			return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
		}
		throw new RuntimeException("Error while creating record");
		
	}
	
	@GetMapping("/employees/roles")
	public List<?> getRoles(){
		return employeeService.getUserRoles();
		
	}
	
	
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<Employee>  getEmployee(@PathVariable Long id){
//
//		Employee employee = employeeService.retrieveEmployeeById(id);
//	 if(employee!=null) {
//		return new ResponseEntity<Employee>(employeeService.retrieveEmployeeById(id),HttpStatus.OK);
//	} else {
//		throw new EmployeeNotFoundException("Employee not found for Id "+id);
//	  }
//	}
	
	@PostMapping("/employees/{employeeId}/activity")
	public ResponseEntity<?>  saveEmployeeActivity(@PathVariable (value = "employeeId") Long employeeId,
			@Valid @RequestBody SwapingActivity swapingActivity) {
		
		EmployeeActivity saveEmployeeActivity = employeeService.saveEmployeeActivity(swapingActivity,employeeId);
		if(saveEmployeeActivity!=null) {
			return new ResponseEntity<EmployeeActivity>(saveEmployeeActivity, HttpStatus.OK);
		}
		throw new RuntimeException("Error while inserting in activity");
		
	}
	
	
}
