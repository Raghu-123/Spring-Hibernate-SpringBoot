package com.wipro.register.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.register.bean.CredentialsBean;
import com.wipro.register.bean.ProfileBean;


@Repository(value="profileDao")
public class ProfileDaoImpl implements ProfileDao
{
@Autowired
private SessionFactory sessionFactory;

public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
@Transactional
public String addUser(ProfileBean user) {
	
	
	String msg = "ERROR";
	System.out.println("4");

	if (user != null)
	{
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(user);
			msg = "SUCCESS";
		} catch (Exception e) {
			msg = "INVALID_INPUT";
		}
	}

	return msg;

}
@SuppressWarnings("deprecation")
@Override
@Transactional
public String generateUserId(String name, String seqName) {
	String result = "FAIL";
	
	if(name!=null && name.length()>2 && seqName!=null){
		java.sql.Connection connection=(Connection) sessionFactory.getCurrentSession();
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt
					.executeQuery("Select "+seqName+".nextval from dual");
			if (resultSet.next()) {
				result = name.substring(0, 2).toUpperCase() + resultSet.getString(1);
				System.out.println("### : "+result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = "INVALID_INPUT";
		}
		System.out.println(result);
	}

	return result;
}

}

