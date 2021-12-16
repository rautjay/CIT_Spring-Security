package com.auth.security.cofig;

import java.net.UnknownServiceException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.security.entity.CustomUserDetails;
import com.auth.security.entity.User;
import com.auth.security.repo.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	User user = repository.findByUsername(username);
	
	if(user==null) {
		throw new UsernameNotFoundException("user not found!!"); 
	
	}
	   CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
		
	}
	
	

}
