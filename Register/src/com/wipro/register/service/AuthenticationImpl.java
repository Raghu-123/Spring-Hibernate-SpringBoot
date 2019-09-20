package com.wipro.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.itextpdf.text.log.SysoLogger;
import com.wipro.register.bean.CredentialsBean;
import com.wipro.register.dao.CredentialsDao;

@Service(value = "authentication")
public class AuthenticationImpl implements Authentication
{
	@Autowired
	CredentialsDao credentialsdao;
	@Override
	public String authorize(String userid)
	{
		// TODO Auto-generated method stub
		String userType = " ";
		CredentialsBean cb = credentialsdao.findbyID(userid);
		userType=cb.getUsertype();
		if (!userType.equalsIgnoreCase("A") && !userType.equalsIgnoreCase("U"))
		{
			userType = "ERROR";
		}
		else {
			userType = cb.getUsertype();
		}
		return userType;

		
	}

	
	@Override
	public boolean isAuthenticated(CredentialsBean cbean)
	{
		boolean isauthenticated = false;
		
		
		if (cbean!= null) {
			System.out.println("I am here ------------");
			CredentialsBean cb =credentialsdao.findbyID(cbean.getUserid());
			if (cb != null) {

				if (cbean.getPassword().equals(cb.getPassword()))
				{
					if (cb.getLoginStatus() == 0)
					{
						isauthenticated = true;
					} else
					{
						System.out.println("status  " + cbean.getLoginStatus());
						isauthenticated = false;
					}
				}
			}
		}

		return isauthenticated;

	}
	

	@Override
	public boolean isLogStatusChanged(CredentialsBean cbean,
			int loginStatus)
	{
		/*System.out.println("CHANGE");
			System.out.println(cbean.toString());

		boolean flag = false;
		if ( cbean!= null)
		{
			//loginStatus=1;
			cbean.setLoginStatus(loginStatus);
		flag = credentialsdao.isStatusUpdated(cbean);
		}

	return flag;*/
		boolean flag = false;
		if (cbean != null)
		{
			System.out.println(loginStatus);
			cbean.setLoginStatus(loginStatus);
			System.out.println(cbean.toString());
		flag =credentialsdao.isStatusUpdated(cbean);
		}

	return flag;
	}
	



	
	
	
	
	
	}

