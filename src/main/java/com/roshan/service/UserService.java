package com.roshan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan.entity.User;
import com.roshan.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(String userId) {
		return userRepository.findByUserId(userId);
	}
}
