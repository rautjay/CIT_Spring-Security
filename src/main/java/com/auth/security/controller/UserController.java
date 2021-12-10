package com.auth.security.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.security.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	 @RequestMapping("/api/users/me")
	    public ResponseEntity<User> profile() 
	    {
	        //Build some dummy data to return for testing
	        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String email = user.getUsername() + "@howtodoinjava.com";
	 
	        User currentuser = new User();
	        currentuser.setUsername(user.getUsername());
	        currentuser.setPassword(email);
	 
	        return ResponseEntity.ok(currentuser);
	    }
	

}
