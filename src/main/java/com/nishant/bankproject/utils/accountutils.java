package com.nishant.bankproject.utils;

import java.time.Year;

public class accountutils {
 
	public static final String Account_exists_code="001";
	public static final String Account_exists_message="This user has an account";
	public static final String Account_creation_success="002";
	public static final String Account_creation_message="Account has successfully created !";

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
