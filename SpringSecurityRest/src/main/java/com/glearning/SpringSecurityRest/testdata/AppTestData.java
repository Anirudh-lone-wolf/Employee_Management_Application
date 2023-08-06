package com.glearning.SpringSecurityRest.testdata;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.github.javafaker.Faker;
import com.glearning.SpringSecurityRest.dao.EmployeeRepository;
import com.glearning.SpringSecurityRest.model.Employee;

@Configuration
public class AppTestData {

	@Autowired
	private EmployeeRepository employeeRepository;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadUsers(ApplicationReadyEvent event) {

		// adding some student data

		Faker faker = new Faker();

		for (int i = 0; i < 5; i++) {

			Employee employee = new Employee();
			// Generate fake employee first name
			String firstName = faker.name().firstName();
			employee.setFirstName(firstName);

			// Generate fake employee last name
			String lastName = faker.name().firstName();
			employee.setLastName(lastName);

			// Generate fake employee email
			employee.setEmail(generateEmployeeEmail(firstName, lastName));

			this.employeeRepository.save(employee);
		}
	}

	public String generateEmployeeEmail(String firstName, String lastName) {
		String sanitizedFirstName = firstName.toLowerCase();
		String sanitizedLastName = lastName.toLowerCase();
		return sanitizedFirstName + "." + sanitizedLastName + "@glearning.com";
	}
}
