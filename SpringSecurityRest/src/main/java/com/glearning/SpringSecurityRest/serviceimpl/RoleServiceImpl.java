package com.glearning.SpringSecurityRest.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.SpringSecurityRest.dao.RoleRepository;
import com.glearning.SpringSecurityRest.model.Roles;
import com.glearning.SpringSecurityRest.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Roles addRole(Roles role) {
		return roleRepository.save(role);
	}

}
