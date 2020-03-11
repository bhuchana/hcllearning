package hcl.com.learning.timetracking.repository;

import org.springframework.data.repository.CrudRepository;

import hcl.com.learning.timetracking.model.EmployeeActivity;

public interface EmployeeActivityRepository extends CrudRepository<EmployeeActivity, Long> {

}
