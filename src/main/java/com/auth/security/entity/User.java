package com.auth.security.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String  username;
	private String password;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<User_Role> userroles = new HashSet<>();
	
	private boolean enabled = true;
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<User_Role> getUserroles() {
		return userroles;
	}
	public void setUserroles(Set<User_Role> userroles) {
		this.userroles = userroles;
	}
	
	public User() {
		super();
	}
	public User(int user_id, String username, String password, Set<User_Role> userroles, boolean enabled) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.userroles = userroles;
		this.enabled = enabled;
	}
	
	
	


}
