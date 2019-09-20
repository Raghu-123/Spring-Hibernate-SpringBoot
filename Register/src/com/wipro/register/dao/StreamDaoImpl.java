package com.wipro.register.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.register.bean.StreamBean;
import com.wipro.register.model.Stream;





	@Repository(value=" streamdao")
	
	
		public class StreamDaoImpl implements StreamDao {
		@Autowired
		SessionFactory sessionFactory;


		@Override
		@Transactional
		public String addstream(Stream stream) 
		{
			String msg="FAIL";
			
			Session session = sessionFactory.getCurrentSession();
			try {
				
				session.saveOrUpdate(stream);
				
				msg = "SUCCESS";
			} catch (Exception e) {
				
				System.out.println(e);
				msg = "INVALID_INPUT";
			}
		
		//System.out.println(module.getSubjectid()+"@$"+stream.getSubjecttitle());
		//System.out.println("in admodule"+msg);
		return msg;
			
			
		}


		@SuppressWarnings("unchecked")
		@Override
		@Transactional
		public List<Stream> liststreams() {
			return (List<Stream>) sessionFactory.getCurrentSession().createCriteria(Stream.class).list();
			
		}


		@Override
		@Transactional
		public String generateId(String streamname, String seqName) {

			String msg="";
			 
			
		 @SuppressWarnings("deprecation")
		 java.sql.Connection connection=(Connection) sessionFactory.getCurrentSession();
		
			 try
			 {
				 Statement stmt=connection.createStatement();
				ResultSet rs=stmt.executeQuery("Select "+seqName+".nextval from dual");
				
				 if(rs.next())
				 {
				msg = streamname.substring(0, 2).toUpperCase() + rs.getString(1);
					
				 }
				 
			 }
			 catch(Exception e)
			 {
				 System.out.println("INVALID ID");
			 }
		
		return msg;
		}


		@Override
		@Transactional
		public Stream getstream(String streamId) {
			Stream stream=new Stream();
			//System.out.println(module.getSubjectid());
			return (Stream) sessionFactory.getCurrentSession().get(Stream.class, streamId);
		}


		@Override
		@Transactional
		public void deletestream(Stream stream)
		{
			StreamBean sbean=new StreamBean();
			sessionFactory.getCurrentSession().delete(stream.getStreamid(), stream);
			//System.out.println(stream.getStreamid()+"bdhvbhfdbv");
			System.out.println(stream.toString());
		
		}
		@Transactional
		 public String updateStream(String streamid, Stream stream)
		 {
			 String msg="FAIL";
				
				Session session = sessionFactory.getCurrentSession();
				try {
					
					session.saveOrUpdate(streamid,stream);
					
					msg = "SUCCESS";
				} catch (Exception e) 
				{
					
					System.out.println(e);
					msg = "INVALID_INPUT";
				}
			return msg;
			 
		 }


	
	}

