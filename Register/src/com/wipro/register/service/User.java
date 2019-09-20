package com.wipro.register.service;

import com.wipro.register.bean.CredentialsBean;
import com.wipro.register.bean.ProfileBean;

public interface User {
	String register(ProfileBean profile);
	String login(CredentialsBean cred);
	boolean isOut(CredentialsBean cbean);
	boolean isPasswordChanged(CredentialsBean cbean, String newpassword);
}
