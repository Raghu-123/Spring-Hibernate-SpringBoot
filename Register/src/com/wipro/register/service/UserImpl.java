package com.wipro.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.register.bean.CredentialsBean;
import com.wipro.register.bean.ProfileBean;
import com.wipro.register.dao.CredentialsDao;
import com.wipro.register.dao.ProfileDao;

@Service("user")
public class UserImpl implements User {
	
	@Autowired
	Authentication authentication;
	
	@Autowired
	ProfileDao profileDao;
	
	@Autowired
	CredentialsDao credentialsDao;

	@Override
	public String register(ProfileBean profile) {
		CredentialsBean cbean=new CredentialsBean();
		String msg = "FAIL";
	System.out.println("1");
		if (profile!= null) 
		{
			System.out.println(profile);
			if (profile.getUsername()!= null
					&& profile.getEmailid()!= null
					&& profile.getContactno()!= null && profile.getPassword()!= null) 
			{
				System.out.println("3");
				String userId = profileDao.generateUserId(profile.getUsername(),"userid_seq");
				if (!userId.equalsIgnoreCase("INVALID_INPUT") && !userId.equalsIgnoreCase("FAIL"))
				{
					
				
				profile.setStudentid(userId);
				
				
				
				String profileresult=profileDao.addUser(profile);
				
				
				if (profileresult.equals("SUCCESS"))
				{
					cbean.setUserid(userId);
					cbean.setPassword(profile.getPassword());
					cbean.setUsertype("U");
					msg= credentialsDao.createCredentials(cbean);
				} 
				else 
				{
					msg= "FAIL";
				}

			} 
				
			else 
			{
				msg="FAIL";
			}
			}
		
		}
		return msg;	
	}

	@Override
	public String login(CredentialsBean cred) {
		// TODO Auto-generated method stub
		
		String msg=" ";
		//CredentialsBean bean=new CredentialsBean();
		/*String msg="FAIL";
		if(cred!=null)
		{
			//bean=credentialsDao.findbyID(cred.getUserid());
			msg=authentication.authorize(cred.getUsertype());
			System.out.println(msg);
			if(msg!=null)
			{
				//msg=bean.getUsertype();
			}
		}
		return msg;*/
		if (cred!= null) 
		{

			if (authentication.isAuthenticated(cred)) 
			{

				msg = authentication.authorize(cred.getUserid());
				if (msg != null) {
					if (msg.equalsIgnoreCase("A") || msg.equalsIgnoreCase("u")) {
						if (!authentication.isLogStatusChanged(cred, 1)) {
							msg = "ERROR";
						}

					}

				}

			} else {
				msg = "INVALID_USER";
			}
		}

		return msg;
	}

	@Override
	public boolean isOut(CredentialsBean cbean) {
		//AuthenticationImpl cservice=new AuthenticationImpl();
		boolean result = false;
		System.out.println("STATUS="+cbean.toString());
		if (cbean!= null)
		{
			System.out.println("STATUS="+cbean.toString());
			if (authentication.isLogStatusChanged(cbean, 0)) 
			{
				result = true;
			}

		}
		return result;
	}

	@Override
	public boolean isPasswordChanged(CredentialsBean cbean, String newpassword) {
		boolean isUpdated = false;
		//System.out.println(userid);
		CredentialsBean cb=new CredentialsBean();
		System.out.println(cbean.getUserid());
		System.out.println(newpassword);
		if ( newpassword != null) 
		{
			System.out.println( " 123 ######### " + newpassword);
			isUpdated = credentialsDao.isPwdUpdated(cbean, newpassword);
		}
		return isUpdated;
	}

}
