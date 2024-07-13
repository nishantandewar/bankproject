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
import com.nishant.bankproject.dto.TransferRequest;
import com.nishant.bankproject.dto.UserRequest;
import com.nishant.bankproject.service.impl.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user")
@Tag( name="User Account Management APTs")
public class UserController {
  	
	@Autowired 
	UserService userService;
	
	@Operation(
			summary="create new user Account",
			description="Creating new user Account and assigning an accountID"
			)
	@ApiResponse(
			responseCode = "201",
			description="HTTP 201 created")
	
	
	@PostMapping 	
	public BankResponse createaccount(@RequestBody UserRequest userRequest) {
		return userService.createaccount(userRequest);
	}
	
	@Operation(
			summary="Balance Enquiry",
			description="Checking the amount of Balance of the user"
			)
	@ApiResponse(
			responseCode = "200",
			description="HTTP 200 SUCCESS")
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
	
	@GetMapping("transferRequest")
	public BankResponse transferAmount(@RequestBody TransferRequest request) {
		return userService.transfer(request);
	}
}























