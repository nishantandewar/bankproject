package com.nishant.bankproject.service.impl;

import com.nishant.bankproject.dto.TransactionRequest;


public interface TransactionService {
  void saveTransaction(TransactionRequest transaction);	
}
