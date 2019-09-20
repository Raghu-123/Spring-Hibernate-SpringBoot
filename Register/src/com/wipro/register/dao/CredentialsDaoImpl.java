package com.wipro.register.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.register.bean.CredentialsBean;

@Repository(value="credentialsDao")
public class CredentialsDaoImpl implements CredentialsDao
{
	@Autowired
	SessionFactory sessionFactory;
		public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public String createCredentials(CredentialsBean cbean) {
		String result = "FAIL";
		try {
			sessionFactory.getCurrentSession().save(cbean);
			result = "SUCCESS";
		} catch (Exception e) {
			result = "FAIL";
		}
		return result;
	}

	@Override

	@Transactional
	public CredentialsBean findbyID(String userid) {
	
		CredentialsBean user=(CredentialsBean) sessionFactory.getCurrentSession().get(CredentialsBean.class,userid);
		System.out.println(user);
		return user;
		
	}
	@Transactional
	
	public  boolean isStatusUpdated(CredentialsBean credentialsbean)
	 {
		boolean isUpdated = false;
		try {
			Session session = sessionFactory.getCurrentSession();
		
			
			CredentialsBean cbean = (CredentialsBean) session.get(CredentialsBean.class, credentialsbean.getUserid());
			System.out.println(credentialsbean.getLoginStatus()+" *********");
			cbean.setLoginStatus(credentialsbean.getLoginStatus());
			System.out.println(cbean.getLoginStatus());
			isUpdated = true;
			//session.saveOrUpdate(credentialsbean);
			
			
		} catch (Exception e) {
			System.out.println(" While updated there is a error....");
			e.printStackTrace();
		}

		return isUpdated ;
	}
	@Override
	@Transactional
	public boolean isPwdUpdated(CredentialsBean cbean, String newpassword) {
		boolean isUpdated = false;

		if ( newpassword != null)
		{
			
				
			
			
			try
			{
				Session session = sessionFactory.getCurrentSession();
				
				CredentialsBean credbean = (CredentialsBean) session.get(CredentialsBean.class, cbean.getUserid());
				String pass=credbean.getPassword();
				System.out.println(pass);
				if (cbean.getPassword().equals(pass))
				{
					System.out.println("333333"+cbean.getNewpassword());
				
				credbean.setPassword(cbean.getNewpassword());
				credbean.setLoginStatus(0);
			
				isUpdated = true;
			}
				}
				catch (Exception e)
			{
				System.out.println(" While updated there is a error....");
				e.printStackTrace();
			}
			
		}
		else
		{
			isUpdated = false;
		}

		return isUpdated;
		
	}
		 
	 }
	

