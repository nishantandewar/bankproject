package com.nishant.bankproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nishant.bankproject.dto.TransactionRequest;
import com.nishant.bankproject.entity.Transaction;
import com.nishant.bankproject.repository.TransactionRepository;

@Component
public class TransactionServiceimpl implements TransactionService {

	
	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public void saveTransaction(TransactionRequest transactionRequest) {
		
		Transaction transaction=Transaction.builder()
				.TransactionType(transactionRequest.getTransactionType())
				.transactionID("201")
				.Amount(transactionRequest.getAmount())
				.status(transactionRequest.getStatus())
				.build();
		
		transactionRepository.save(transaction);
		
	}
	  

}
