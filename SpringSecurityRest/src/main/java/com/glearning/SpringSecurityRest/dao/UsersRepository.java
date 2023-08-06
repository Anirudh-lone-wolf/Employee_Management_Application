package com.glearning.SpringSecurityRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glearning.SpringSecurityRest.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	@Query("SELECT u FROM Users u WHERE u.username = ?1")
	public Users getUserByUsername(String username);

}
