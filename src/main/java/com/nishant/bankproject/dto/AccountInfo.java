package com.nishant.bankproject.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {
	@Schema(
			name="User Account Name")
     private String accountname;
	@Schema(
			name="User Acount Balanace")
     private BigDecimal accountbalance;
	@Schema(
			name="user Account Balance")
     private String accountnumber;
}
