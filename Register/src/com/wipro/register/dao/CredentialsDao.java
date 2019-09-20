package com.wipro.register.dao;

import com.wipro.register.bean.CredentialsBean;

public interface CredentialsDao
{
	String createCredentials(CredentialsBean cbean);
	 CredentialsBean findbyID(String userid);
	  boolean isStatusUpdated(CredentialsBean cbean);
	   boolean isPwdUpdated(CredentialsBean cbean, String newpassword);
}
