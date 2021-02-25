package com.ogzymrtc.ism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogzymrtc.ism.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
