package com.nishant.bankproject.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.bankproject.dto.AccountInfo;
import com.nishant.bankproject.dto.BankResponse;
import com.nishant.bankproject.dto.EmaiDetails;
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
  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
