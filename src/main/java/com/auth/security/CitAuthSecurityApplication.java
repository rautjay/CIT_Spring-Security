package com.auth.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth.security.entity.Role;
import com.auth.security.entity.User;
import com.auth.security.entity.User_Role;
import com.auth.security.service.UserService;

@SpringBootApplication
public class CitAuthSecurityApplication {

//	@Autowired 
//	private UserService userservice;
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	

	
	public static void main(String[] args) {
		SpringApplication.run(CitAuthSecurityApplication.class, args);
		
		
	}

	
	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		 User user = new User(); 
//		 user.setUsername("tasdiq");
//		 user.setPassword(bCryptPasswordEncoder.encode("tasdiq@123"));
//		 Role role1 = new Role(); 
//		 role1.setRoleId(46L);
//		 role1.setName("MANAGER");
//		  
//		 Set<User_Role> userrolesSet = new HashSet<>(); 
//		 User_Role userrole = new User_Role(); 
//		 userrole.setRole(role1); 
//		 userrole.setUser(user);
//		 userrolesSet.add(userrole);
//		 User user1 = this.userservice.createUser(user, userrolesSet);
//
//		
//		     
//		
//	}

}
