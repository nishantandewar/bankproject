package com.nishant.bankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.bankproject.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{
     
	
}
