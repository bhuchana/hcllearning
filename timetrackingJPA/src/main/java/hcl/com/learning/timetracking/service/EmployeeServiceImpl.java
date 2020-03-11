package hcl.com.learning.timetracking.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hcl.com.learning.timetracking.model.Employee;
import hcl.com.learning.timetracking.model.EmployeeActivity;
import hcl.com.learning.timetracking.model.SwapingActivity;
import hcl.com.learning.timetracking.model.UserRoleDTO;
import hcl.com.learning.timetracking.repository.EmployeeActivityRepository;
import hcl.com.learning.timetracking.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeActivityRepository employeeActivityRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee save(Employee employee) throws RuntimeException {
		return employeeRepository.save(employee);
	}

	
//	@Override
//	public Employee retrieveEmployeeById(Long employeeId) throws EmployeeNotFoundException {
//		return employeeDao.retrieveEmployeeById(employeeId);
//	}

	@Override
	@Transactional
	public EmployeeActivity saveEmployeeActivity(SwapingActivity swapingActivity, Long employeeId ) throws RuntimeException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		
		EmployeeActivity employeeActivity=new EmployeeActivity();
		if(employee.isPresent()) {
			Employee employee2 = employee.get();
			employeeActivity.setLocation(swapingActivity.getLocation());
			employeeActivity.setSwapActivity(swapingActivity.getSwapActivity());
			employeeActivity.setSwipeDateTime(swapingActivity.getSwipeDateTime());
			employeeActivity.setEmployee(employee2);
			employeeActivity=employeeActivityRepository.save(employeeActivity);
		}
		
		return employeeActivity;
	}


	@Override
	public List<UserRoleDTO> getUserRoles() {
		
		List<Map<String, Object>> rolesWithCount = employeeRepository.findUserRolesWithCount();
		List<UserRoleDTO> userRoleDTOs=new ArrayList<>(); 
		rolesWithCount.forEach(userrole -> {
			String role = (String) userrole.get("role");
			Integer count = ((BigInteger) userrole.get("count")).intValue();
			UserRoleDTO dto=new UserRoleDTO(role, count);
			userRoleDTOs.add(dto);
		});
		
		return userRoleDTOs;
	}

	
    

}
