package com.auth.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
