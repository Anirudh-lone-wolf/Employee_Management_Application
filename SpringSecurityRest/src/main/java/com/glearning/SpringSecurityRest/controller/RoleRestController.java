package com.glearning.SpringSecurityRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.SpringSecurityRest.model.Roles;
import com.glearning.SpringSecurityRest.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleRestController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/addRole")
	public Roles addRole(@RequestBody Roles role) {
		return roleService.addRole(role);
	}

}
