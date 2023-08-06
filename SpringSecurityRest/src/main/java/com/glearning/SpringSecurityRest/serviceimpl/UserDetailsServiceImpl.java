package com.glearning.SpringSecurityRest.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glearning.SpringSecurityRest.dao.UsersRepository;
import com.glearning.SpringSecurityRest.model.Users;
import com.glearning.SpringSecurityRest.security.AdditionalUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = usersRepository.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new AdditionalUserDetails(user);

	}

}
