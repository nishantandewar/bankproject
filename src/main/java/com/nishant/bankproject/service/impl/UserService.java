package com.nishant.bankproject.service.impl;

import com.nishant.bankproject.dto.BankResponse;
import com.nishant.bankproject.dto.CreditDebitRequest;
import com.nishant.bankproject.dto.EnquiryRequest;
import com.nishant.bankproject.dto.TransferRequest;
import com.nishant.bankproject.dto.UserRequest;

public interface UserService {
	
   public BankResponse createaccount(UserRequest UserRequest);
   public BankResponse balanceEnquiry(EnquiryRequest enquiryrequest);
   String nameEnquiry(EnquiryRequest enquiryrequest);
   public BankResponse credit(CreditDebitRequest request);
   public BankResponse debit(CreditDebitRequest request);
   BankResponse transfer(TransferRequest request);
}
