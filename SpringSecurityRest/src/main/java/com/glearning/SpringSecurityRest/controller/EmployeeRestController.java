package com.glearning.SpringSecurityRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.SpringSecurityRest.model.Employee;
import com.glearning.SpringSecurityRest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> fetchAllEmployees() {
		return employeeService.fetchAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") long id) {
		return employeeService.fetchEmployeeById(id);
	}

	@PostMapping("/employees/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PutMapping("/employees/update")
	public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") long id) {
		return employeeService.deleteEmployee(id);
	}

	@GetMapping("/employees/search/{firstName}")
	public List<Employee> fetchEmployeeByFirstName(@PathVariable("firstName") String firstName) {

		List<Employee> searchEmployees;

		if (firstName != null && !firstName.trim().isEmpty()) {
			searchEmployees = employeeService.fetchEmployeeByFirstName(firstName);
		} else {
			searchEmployees = employeeService.fetchAllEmployees();
		}

		return searchEmployees;
	}

	/*
	 * This is an additional method for search in case full first name must be
	 * passed for search.
	 * 
	 * @GetMapping("/employees/search/{firstName}") public List<Employee>
	 * fetchEmployeeByFirstNameWithExampleMatcher(@PathVariable String firstName) {
	 * 
	 * List<Employee> searchEmployees;
	 * 
	 * if (firstName != null && !firstName.trim().isEmpty()) { searchEmployees =
	 * employeeService.fetchEmployeeByFirstNameWithExampleMatcher(firstName); } else
	 * { searchEmployees = employeeService.fetchAllEmployees(); }
	 * 
	 * return searchEmployees; }
	 */

	@GetMapping("/employees/sort")
	public List<Employee> sortEmployees(@RequestParam(name = "order", defaultValue = "asc") Direction direction) {
		return employeeService.sortEmployees(direction);
	}

}
