package com.wipro.register.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.register.bean.ParticipantsBean;
import com.wipro.register.model.Participants;




@Repository(value="ParticipantsDao")

public class ParticipantsDaoImpl implements ParticipantsDao 
{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional

	public String addparticipants(Participants Participants)
	
	{
		System.out.println(Participants.getEmail());
		String msg="FAIL";
		
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.saveOrUpdate(Participants);
			
			msg = "SUCCESS";
		} catch (Exception e) {
			
			System.out.println(e);
			msg = "INVALID_INPUT";
		}
	
	
	System.out.println("in admodule"+msg);
	return msg;
}

	@Override
	@Transactional
	public String generateId(String name, String seqName) 
	{

		String msg="";
		 
		
		java.sql.Connection connection=(Connection) sessionFactory.getCurrentSession();
	
		 try
		 {
			 Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("Select "+seqName+".nextval from dual");
			
			 if(rs.next())
			 {
			msg = name.substring(0, 2).toUpperCase() + rs.getString(1);
				
			 }
			 
		 }
		 catch(Exception e)
		 {
			 msg="INVALID";
			 System.out.println("INVALID ID");
		 }
	
	return msg;


	}

	@Override
	@Transactional
	public List<Participants> listparticipants() 
	{
		
		return (List<Participants>) sessionFactory.getCurrentSession().createCriteria(Participants.class).list();
		
	}

	@Override
	@Transactional
	public Participants getParticipants(String empId)
	
	{
		
		Participants participants=new Participants();
		System.out.println(participants.getEmpid());
		return (Participants) sessionFactory.getCurrentSession().get(Participants.class, empId);
	
	}

	@Override
	@Transactional
	public void deleteParticipants(Participants participants) 
	
	{
		ParticipantsBean pBean=new ParticipantsBean();
		System.out.println("Delete "+participants.getEmpid());
		//sessionFactory.getCurrentSession().createQuery("delete from Module where subjectid = "+module.getSubjectid()).executeUpdate();
		sessionFactory.getCurrentSession().delete(participants.getEmpid(), participants);
		System.out.println();
		
	}

	@Override
	@Transactional
	public String UpdateParticipant(String empid, Participants Participants) {
		
String msg="FAIL";
		
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.saveOrUpdate(empid, Participants);
			
			msg = "SUCCESS";
		} catch (Exception e) {
			
			System.out.println(e);
			msg = "INVALID_INPUT";
		}
		return msg;
	}





	}
	
	


