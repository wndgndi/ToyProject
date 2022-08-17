package com.fastcampus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fastcampus.biz.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/auth/login")
	public String login() {
		return "system/login";
	}
	
}
