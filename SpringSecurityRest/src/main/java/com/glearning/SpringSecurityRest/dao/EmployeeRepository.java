package com.glearning.SpringSecurityRest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.glearning.SpringSecurityRest.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select * from Employee e where e.first_Name like %:keyword%", nativeQuery = true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);

}
