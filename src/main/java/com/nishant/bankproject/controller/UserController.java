package com.nishant.bankproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.bankproject.dto.BankResponse;
import com.nishant.bankproject.dto.UserRequest;
import com.nishant.bankproject.service.impl.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
  
	
	@Autowired 
	UserService userService;
	
	@PostMapping 	
	public BankResponse createaccount(@RequestBody UserRequest userRequest) {
		return userService.createaccount(userRequest);
	}
}
