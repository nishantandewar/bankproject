package com.nishant.bankproject.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class TransactionRequest {

	private String TransactionType;
	private BigDecimal Amount;
	private String AccountNumber;
	private String status;
}
