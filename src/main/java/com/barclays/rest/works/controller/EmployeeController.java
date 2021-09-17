package com.barclays.rest.works.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.rest.works.contract.IEmployeeService;
import com.barclays.rest.works.entity.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService service; 
	
	@GetMapping("/")
	public String health() {
		return "Working... to check health";
	}
	
//	@GetMapping("/dummy-emp")
//	public Employee getDummyEmployee() {
//		return service.dummyEmployee();
//	}
	

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees(); 
	}

	@GetMapping("/employees/{empId}")
	public Employee getEmployee( @PathVariable("empId")  int empId) {
		return service.getEmployeeById(empId); 
	}
	
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.insertEmployee(employee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee( @PathVariable("empId")  int empId) {
		 return service.deleteEmployee(empId); 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> getEmployeesByName(@RequestParam(value="empName") String empName){
		return service.getEmployeesByName(empName);
	}
	
	/*@GetMapping("/employees/{empName}")
	public Employee getEmployee( @PathVariable("empName")  String empName) {
		return service.getEmployeesByName(empName);
	}*/
	
	@GetMapping("/salary")
	public List<Employee> getSalary(@RequestParam("min") double min,
			@RequestParam("max") double max){
		return service.getEmployeesBetweenSalary(min,max);
		
	}
}