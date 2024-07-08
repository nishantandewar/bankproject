package com.nishant.bankproject.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.bankproject.dto.AccountInfo;
import com.nishant.bankproject.dto.bankresponse;
import com.nishant.bankproject.dto.userrequest;
import com.nishant.bankproject.entity.user;
import com.nishant.bankproject.repository.userrepository;
import com.nishant.bankproject.utils.accountutils;
@Service
public class userserviceimpl implements userservice {
    
	
	@Autowired
	userrepository userRepository;
	
	@Override
	public bankresponse createaccount(userrequest userRequest) {
		/*
		 * creating an account means saving the details of user in database
		 * */
		if(userRepository.existsByEmail(userRequest.getEmail())){
			return bankresponse.builder()
					.responsecode(accountutils.Account_exists_code)
					.responsemessage(accountutils.Account_exists_message)
					.accountinfo(null)
					.build();
					
		}
		user newuser=user.builder()
				        .firstname(userRequest.getFirstname())
				        .lastname(userRequest.getLastname())
				        .othername(userRequest.getOthername())
				        .gender(userRequest.getGender())
				        .address(userRequest.getAddress())
				        .stateoforigin(userRequest.getStateoforigin())
				        .accountnumber(accountutils.generateaccountnumber())
				        .accountbalance(BigDecimal.ZERO)
				        .email(userRequest.getEmail())
				        .phonenumber(userRequest.getPhonenumber())
				        .alternatephonenumber(userRequest.getAlternatephonenumber())
				        .status("ACTIVE ")
				.build();
		
		user saveduser=userRepository.save(newuser);
		return bankresponse.builder()
				.responsecode(accountutils.Account_creation_success)
				.responsemessage(accountutils.Account_creation_message)
				.accountinfo(AccountInfo.builder()
						.accountbalance(saveduser.getAccountbalance())
						.accountnumber(newuser.getAccountnumber())
						.accountname(saveduser.getFirstname()+" "+saveduser.getLastname()+" "+saveduser.getOthername())
						.build())
				.build();
	}
  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
