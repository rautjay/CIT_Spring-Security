package com.auth.security.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.auth.security.entity.User;
import com.auth.security.entity.User_Role;

@Service
public interface UserService {

	public User createUser(User user,Set<User_Role> userroles) throws Exception;

}
