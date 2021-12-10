package com.auth.security.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
private User user;
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	 List<User_Role> userroles =  user.getUserroles();
	 
     Set<SimpleGrantedAuthority> authorities = new HashSet<>();

	userroles.forEach(User_Role ->{
		authorities.add(new SimpleGrantedAuthority(User_Role.getRole().getName()));
	});
	  
		
	return authorities;
	}
	


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isEnabled();
	}

	

}
