package hcl.com.learning.timetracking.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hcl.com.learning.timetracking.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByFirstNameAndLastName(String firstName,String lastName);
	
	@Query(value="select user_role as role,count(*) as count from Employee group by user_role",nativeQuery=true)
	List<Map<String, Object>> findUserRolesWithCount();
	
}
