package com.glearning.SpringSecurityRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.SpringSecurityRest.model.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

}
