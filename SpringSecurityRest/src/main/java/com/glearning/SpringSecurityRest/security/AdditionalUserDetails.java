package com.glearning.SpringSecurityRest.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.glearning.SpringSecurityRest.model.Roles;
import com.glearning.SpringSecurityRest.model.Users;

public class AdditionalUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private Users user;

	public AdditionalUserDetails(Users user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<Roles> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return authorities;

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
