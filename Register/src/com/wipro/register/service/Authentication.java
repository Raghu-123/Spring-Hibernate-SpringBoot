package com.wipro.register.service;

import com.wipro.register.bean.CredentialsBean;

public interface Authentication
{
	 String authorize(String userid);
	 boolean isAuthenticated(CredentialsBean cbean);
	 boolean isLogStatusChanged(CredentialsBean credentialsBean, int loginStatus);
	  

}
