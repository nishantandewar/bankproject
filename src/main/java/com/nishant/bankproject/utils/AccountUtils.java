package com.nishant.bankproject.utils;

import java.time.Year;

public class AccountUtils {
 
	public static final String Account_exists_code="001";
	public static final String Account_exists_message="This user has an account";
	public static final String Account_not_exists_message="This user does not have an account";
	public static final String Account_creation_success="002";
	public static final String Account_creation_message="Account has successfully created !";
	public static final String Account_not_exists_code = "404";
	public static final String Transfer_success_message="Transfer Successful";
	public static final String Transfer_success_code="129";

	public static String generateaccountnumber() {
		Year currentyear =Year.now();
		int min=100000;
		int max=999999;
		
		//random no.
		int randmno=(int)Math.floor(Math.random()*(max-min+1)+min);
		String year=String.valueOf(currentyear);
		String randomno=String.valueOf(randmno);
		
		StringBuilder accountnumber=new StringBuilder();
		return accountnumber.append(year).append(randomno).toString();
	}
	
	
}
