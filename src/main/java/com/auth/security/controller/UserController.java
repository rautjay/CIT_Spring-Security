package com.auth.security.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.auth.security.entity.Role;
import com.auth.security.entity.User;
import com.auth.security.entity.User_Role;
import com.auth.security.repo.UserRepository;
import com.auth.security.service.UserService;
import com.auth.security.serviceImpl.UserServiceImpl;

import antlr.collections.List;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl impl;
//	@Autowired
//	private RestOperations template;
//	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping(value = "/api/me")
	    public ResponseEntity<User> profile() 
	    {
	        //Build some dummy data to return for testing
	        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String email = user.getUsername();
	 
	        User currentuser = new User();
	        currentuser.setUsername(user.getUsername());
	        currentuser.setPassword(email);
	 
	        return ResponseEntity.ok(currentuser);
	    }
//	 
//	 
//	 @PostMapping(value = "/save")
//	 public java.util.List<User> AddUser(@RequestBody User user) throws Exception{
//
//		//for adding Role
//			
//			Set<User_Role> roleset = new HashSet<>();
//		     Role role = new Role();
//		     role.setRoleId(45L);
//		     role.setName("USER");
//		     
//		     User_Role userrole =  new User_Role();
//		     userrole.setUser(user);
//		     userrole.setRole(role);
//		     roleset.add(userrole);
//		     
//		     //ROLE ADDING ENDS HERE
//				
//			   user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//			   
//			   User Reg_user = this.impl.createUser(user, roleset);
//			   return this.userRepository.findAll();
//			 
//}
//	@GetMapping(value = "/load")
//	public java.util.List<User> Loadall(){
//		
//		return this.userRepository.findAll();
//	}
	
//	@PostMapping(value = "/test",produces = {"application/JSON"},consumes = {"tesxt/plain"})
//	public String getuserdetails(@RequestParam(name = "username",defaultValue = "0") String name) {
//		
//	
//		return "Working properly";
//	}

	@GetMapping(value = "/api/hello")
	public String hello() {
		
		return "hello Everyone!!!";
	}

	 
}
