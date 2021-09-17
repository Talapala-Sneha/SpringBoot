  
package com.barclays.rest.works.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.barclays.rest.works.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

	// you can build custom queries here
	@Query
	(value= "{'salary': {$gt:?0,$lt:?1}}")
	List<Employee> getSalaryBtw(double min, double max);
	
    @Query("{empName:?0}")
	List<Employee> findByEmpName(String empName);
}