package com.roshan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roshan.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUserId(String userId);

}
