package com.nishant.bankproject.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class Transaction {
   
	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	private String transactionID;
	private String TransactionType;
	private BigDecimal Amount;
	private String AccountNumber;
	private String status;
		 
	
}
