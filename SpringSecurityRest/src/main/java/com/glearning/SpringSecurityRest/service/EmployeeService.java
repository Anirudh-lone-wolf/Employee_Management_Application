package com.glearning.SpringSecurityRest.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.glearning.SpringSecurityRest.model.Employee;

public interface EmployeeService {

	Employee fetchEmployeeById(long id);

	List<Employee> fetchAllEmployees();

	Employee addEmployee(Employee employee);

	Employee updateEmployee(long id, Employee employee);

	String deleteEmployee(long id);

	List<Employee> fetchEmployeeByFirstName(String firstName);

	List<Employee> fetchEmployeeByFirstNameWithExampleMatcher(String firstName);

	List<Employee> sortEmployees(Direction direction);

}
