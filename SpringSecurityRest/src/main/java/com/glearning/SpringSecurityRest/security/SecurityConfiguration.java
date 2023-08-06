package com.glearning.SpringSecurityRest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.glearning.SpringSecurityRest.serviceimpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/api/addUser", "/api/addRole").permitAll()
				.antMatchers("/api/employees/addEmployee").hasAnyAuthority("ADMIN")
				.antMatchers("/api/employees", "/api/employees/{id}", "/api/employees/update",
						"/employees/search/{firstName}", "/employees/sort")
				.hasAnyAuthority("USER", "ADMIN").anyRequest().authenticated().and().httpBasic().and().cors().and()
				.csrf().disable();

		http.authenticationProvider(authenticationProvider());

		return http.build();

	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(PasswordEncoder());
		return authenticationProvider;
	}

	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

}
