package com.glearning.SpringSecurityRest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.glearning.SpringSecurityRest.dao.UsersRepository;
import com.glearning.SpringSecurityRest.model.Roles;
import com.glearning.SpringSecurityRest.model.Users;
import com.glearning.SpringSecurityRest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Users addUser(Users user) {
		Users existingUser = usersRepository.getUserByUsername(user.getUsername());
		if (existingUser == null) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRoles(user.getRoles());
			return usersRepository.save(user);
		} else {
			List<Roles> roles = existingUser.getRoles();
			roles.addAll(user.getRoles());
			existingUser.setRoles(roles);
			return usersRepository.save(existingUser);
		}
	}

}
