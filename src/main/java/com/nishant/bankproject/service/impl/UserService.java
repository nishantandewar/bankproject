package com.nishant.bankproject.service.impl;

import com.nishant.bankproject.dto.BankResponse;
import com.nishant.bankproject.dto.UserRequest;

public interface UserService {
	
   public BankResponse createaccount(UserRequest UserRequest);
}
