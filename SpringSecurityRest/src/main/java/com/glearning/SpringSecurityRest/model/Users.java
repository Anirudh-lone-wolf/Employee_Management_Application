package com.glearning.SpringSecurityRest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;

	private String password;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), 
						inverseJoinColumns = @JoinColumn(name = "role_id"))

	private List<Roles> roles = new ArrayList<>();

	public Users(String username, String password, List<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
