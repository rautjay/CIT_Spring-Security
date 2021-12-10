package com.auth.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class User_Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int User_RoleId;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Role role;

	public int getUser_RoleId() {
		return User_RoleId;
	}

	public void setUser_RoleId(int user_RoleId) {
		User_RoleId = user_RoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User_Role(int user_RoleId, User user, Role role) {
		super();
		User_RoleId = user_RoleId;
		this.user = user;
		this.role = role;
	}

	public User_Role() {
		super();
	}

	
}
