package com.glearning.SpringSecurityRest.controller;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.SpringSecurityRest.model.Users;
import com.glearning.SpringSecurityRest.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public Users addUser(@RequestBody Users users) {
		return userService.addUser(users);
	}

}
