package com.nishant.bankproject.service.impl;

import com.nishant.bankproject.dto.bankresponse;
import com.nishant.bankproject.dto.userrequest;

public interface userservice {
	
   public bankresponse createaccount(userrequest userrequest);
}
