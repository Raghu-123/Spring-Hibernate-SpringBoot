package com.wipro.register.dao;

import com.wipro.register.bean.ProfileBean;

public interface ProfileDao 
{

	 String addUser(ProfileBean user);
	 String generateUserId(String name,String seqName);
}
