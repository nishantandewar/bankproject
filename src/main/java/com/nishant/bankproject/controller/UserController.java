package com.nishant.bankproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.bankproject.dto.BankResponse;
import com.nishant.bankproject.dto.CreditDebitRequest;
import com.nishant.bankproject.dto.EnquiryRequest;
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
	
	@GetMapping("/balanceEnquiry")
	public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request) {
		return userService.balanceEnquiry(request);
	}
	
	@GetMapping("nameEnquiry")
	public String nameEnquiry(@RequestBody EnquiryRequest request) {
		return userService.nameEnquiry(request);
	}
	
	@GetMapping("Credit")
	public BankResponse credit(@RequestBody CreditDebitRequest request) {
		return userService.credit(request);
	}
	
	@GetMapping("Debit")
	public BankResponse debit(@RequestBody CreditDebitRequest request) {
		return userService.debit(request);
	}
}























