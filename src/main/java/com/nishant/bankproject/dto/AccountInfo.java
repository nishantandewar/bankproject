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
public class AccountInfo {
     private String accountname;
     private BigDecimal accountbalance;
     private String accountnumber;
}
