package com.nishant.bankproject.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.bankproject.dto.AccountInfo;
import com.nishant.bankproject.dto.BankResponse;
import com.nishant.bankproject.dto.CreditDebitRequest;
import com.nishant.bankproject.dto.EmaiDetails;
import com.nishant.bankproject.dto.EnquiryRequest;
import com.nishant.bankproject.dto.UserRequest;
import com.nishant.bankproject.entity.User;
import com.nishant.bankproject.repository.UserRepository;
import com.nishant.bankproject.utils.AccountUtils;
@Service
public class UserServiceimpl implements UserService {
    
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailService EmailService;
	
	
	@Override
	public BankResponse createaccount(UserRequest userRequest) {
		/*
		 * creating an account means saving the details of user in database
		 * */
		if(userRepository.existsByEmail(userRequest.getEmail())){
			return BankResponse.builder()
					.responsecode(AccountUtils.Account_exists_code)
					.responsemessage(AccountUtils.Account_exists_message)
					.accountinfo(null)
					.build();
					
		}
		
		User newuser=User.builder()
				        .firstname(userRequest.getFirstname())
				        .lastname(userRequest.getLastname())
				        .othername(userRequest.getOthername())
				        .gender(userRequest.getGender())
				        .address(userRequest.getAddress())
				        .stateoforigin(userRequest.getStateoforigin())
				        .accountnumber(AccountUtils.generateaccountnumber())
				        .accountbalance(BigDecimal.ZERO)
				        .email(userRequest.getEmail())
				        .phonenumber(userRequest.getPhonenumber())
				        .alternatephonenumber(userRequest.getAlternatephonenumber())
				        .status("ACTIVE ")
				.build();
		
		User saveduser=userRepository.save(newuser);
		
		//after saving the user info send an email to the user
		
		EmaiDetails emailDetails=EmaiDetails.builder()
				.receipent(newuser.getEmail())
				.messagebody("congratulations! Bank Account created ***:)***")
				.subject("Account has created. our account number in my bank. Your Accout number is "+ newuser.getAccountnumber())
				.build();
		
		EmailService.emailsender(emailDetails);
		
		return BankResponse.builder()
				.responsecode(AccountUtils.Account_creation_success)
				.responsemessage(AccountUtils.Account_creation_message)
				.accountinfo(AccountInfo.builder()
						.accountbalance(saveduser.getAccountbalance())
						.accountnumber(newuser.getAccountnumber())
						.accountname(saveduser.getFirstname()+" "+saveduser.getLastname()+" "+saveduser.getOthername())
						.build())
				.build();
	}


	@Override
	public BankResponse balanceEnquiry(EnquiryRequest request) {
		Boolean exist=userRepository.existsByAccountnumber(request.getAccountNumber());
		if(!exist) {
			BankResponse.builder()
			.responsecode("404")
			.responsemessage("accountdoes not exist")
			.accountinfo(null)
			.build();
		}
		User found=userRepository.findByAccountnumber(request.getAccountNumber());
		return BankResponse.builder()
				.responsecode(AccountUtils.Account_exists_code)
				.responsemessage(AccountUtils.Account_exists_message)
				.accountinfo(AccountInfo.builder()
						.accountbalance(found.getAccountbalance())
						.accountname(found.getFirstname()+" "+found.getLastname())
						.accountnumber(found.getAccountnumber()	)
						.build())
				.build();
	}


	@Override
	public String nameEnquiry(EnquiryRequest request) {
		Boolean exist=userRepository.existsByAccountnumber(request.getAccountNumber());
		if(!exist) {
			return "user does not exist";
		}
		User found=userRepository.findByAccountnumber(request.getAccountNumber());
		return found.getFirstname()+" "+found.getLastname();
	}


	@Override
	public BankResponse credit(CreditDebitRequest request) {
		User user=userRepository.findByAccountnumber(request.getAccountNumber());
		user.setAccountbalance(user.getAccountbalance().add(request.getAmount()));
		userRepository.save(user);
		return BankResponse.builder()
				.accountinfo(AccountInfo.builder()
						.accountbalance(user.getAccountbalance())
						.accountname(user.getFirstname()+" "+user.getLastname())
						.accountnumber(user.getAccountnumber())
						.build())
				.responsecode("Credited")
				.responsemessage("Successful")
				.build();
	}


	@Override
	public BankResponse debit(CreditDebitRequest request) {
		User user=userRepository.findByAccountnumber(request.getAccountNumber());
		user.setAccountbalance(user.getAccountbalance().subtract(request.getAmount()));
		userRepository.save(user);
		if(request.getAmount().intValue()>user.getAccountbalance().intValue()) {
			return BankResponse.builder()
					.accountinfo(null)
					.responsecode("Error404")
					.responsemessage("Less BankBalance")
					.build();
		}
		return BankResponse.builder()
				.accountinfo(AccountInfo.builder()
						.accountbalance(user.getAccountbalance())
						.accountname(user.getFirstname()+" "+user.getLastname())
						.accountnumber(user.getAccountnumber())
						.build())
				.responsecode("Credited")
				.responsemessage("Successful")
				.build();
	}	}
  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

