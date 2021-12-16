package com.auth.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username );

}
