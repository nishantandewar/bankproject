package com.nishant.bankproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.bankproject.dto.bankresponse;
import com.nishant.bankproject.dto.userrequest;
import com.nishant.bankproject.service.impl.userservice;

@RestController
@RequestMapping("/api/user")
public class usercontroller {
  
	
	@Autowired 
	userservice userService;
	
	@PostMapping 	
	public bankresponse createaccount(@RequestBody userrequest userRequest) {
		return userService.createaccount(userRequest);
	}
}
