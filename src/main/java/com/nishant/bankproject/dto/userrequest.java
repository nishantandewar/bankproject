package com.nishant.bankproject.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class userrequest {
  
	private String firstname;
	private String lastname;
	private String othername;
	private String gender;
	private String address;
	private String stateoforigin;
	private BigDecimal accountbalance;
	private String email;
	private String phonenumber;
	private String alternatephonenumber;
	private String status;
}
