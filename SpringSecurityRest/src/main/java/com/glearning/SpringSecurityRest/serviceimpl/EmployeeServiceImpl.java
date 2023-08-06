package com.glearning.SpringSecurityRest.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.glearning.SpringSecurityRest.dao.EmployeeRepository;
import com.glearning.SpringSecurityRest.model.Employee;
import com.glearning.SpringSecurityRest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee fetchEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent())
			return employee.get();
		else
			throw new IllegalArgumentException("This is an invalid Employee ID. Please enter a Valid ID");
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {

		if (employee != null)
			return employeeRepository.save(employee);

		else
			throw new IllegalArgumentException("This Employee seems to be null. Please enter a valid Employee entity");
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {

		Employee employeeUpdate = fetchEmployeeById(id);
		employeeUpdate.setFirstName(employee.getFirstName());
		employeeUpdate.setLastName(employee.getLastName());
		employeeUpdate.setEmail(employee.getEmail());

		return employeeRepository.save(employeeUpdate);

	}

	@Override
	public String deleteEmployee(long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
			return "Deleted employee id - " + id;
		} else
			throw new IllegalArgumentException("Please enter a valid ID");
	}

	@Override
	public List<Employee> fetchEmployeeByFirstName(String firstName) {
		return employeeRepository.findByKeyword(firstName);
	}

	@Override
	public List<Employee> fetchEmployeeByFirstNameWithExampleMatcher(String firstName) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);

		ExampleMatcher exmatcher = ExampleMatcher.matching().withMatcher(firstName, GenericPropertyMatchers.exact())
				.withIgnoreCase().withIgnorePaths("id", "lastName", "email");

		Example<Employee> example = Example.of(employee, exmatcher);

		return employeeRepository.findAll(example);
	}

	@Override
	public List<Employee> sortEmployees(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

}
