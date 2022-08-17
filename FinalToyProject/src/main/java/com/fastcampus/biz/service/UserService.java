package com.fastcampus.biz.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.User;
import com.fastcampus.biz.persistence.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User getUser(String username) {
		Optional<User> findUser = userRepository.findByUsername(username);
		if(findUser.isPresent()) {
			return findUser.get();	
		}
		return new User();
	}
	
	@Transactional
	public User updateUser(User user) {
		User myuser = userRepository.findByUsername(user.getUsername()).get();
		return myuser;
	}
	
}
