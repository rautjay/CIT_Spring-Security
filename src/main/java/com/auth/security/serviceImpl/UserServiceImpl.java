package com.auth.security.serviceImpl;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth.security.entity.User;
import com.auth.security.entity.User_Role;
import com.auth.security.repo.RoleRepository;
import com.auth.security.repo.UserRepository;
import com.auth.security.service.UserService;

@Component
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	// For Creating user..
	@Override
	public User createUser(User user, Set<User_Role> userroles) throws Exception {
		
		 User localUser =this.userRepository.findByUsername(user.getUsername());
	  if(localUser!=null) {
		  System.out.println("USer already there!!");
		 throw new Exception("User already Present!!");
	  }else {
		  //creating user
		  
		  for(User_Role UR:userroles) {
			  roleRepository.save(UR.getRole());
		  }
		  
		  user.getUserroles().addAll(userroles);
		  localUser= this.userRepository.save(user);
}
	  return null;
}
}
