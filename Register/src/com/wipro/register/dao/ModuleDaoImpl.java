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

import com.wipro.register.bean.ModuleBean;
import com.wipro.register.model.Module;

@Repository(value="Moduledao")
public class ModuleDaoImpl implements ModuleDao 
{
	@Autowired
	SessionFactory sessionFactory;
@Transactional
	public String addmodule(Module module) {
	//ModuleBean mbean=new ModuleBean();
		String msg="FAIL";
		
			Session session = sessionFactory.getCurrentSession();
			try {
				
				session.saveOrUpdate(module);
				
				msg = "SUCCESS";
			} catch (Exception e) {
				
				System.out.println(e);
				msg = "INVALID_INPUT";
			}
		
		System.out.println(module.getSubjectid()+"@$"+module.getSubjecttitle());
		System.out.println("in admodule"+msg);
		return msg;
	}




@Transactional
public String generateId(String subjecttile,String seqName) 
{
		String msg="";
		 
		
	 java.sql.Connection connection=(Connection) sessionFactory.getCurrentSession();
	
		 try
		 {
			 Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("Select "+seqName+".nextval from dual");
			
			 if(rs.next())
			 {
			msg = subjecttile.substring(0, 2).toUpperCase() + rs.getString(1);
				
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
public List<Module> listmodules() 
{
	
	
	return (List<Module>) sessionFactory.getCurrentSession().createCriteria(Module.class).list();
}




@Override
@Transactional
public Module getModule(String subjectId) {

	Module module=new Module();
	System.out.println(module.getSubjectid());
return (Module) sessionFactory.getCurrentSession().get(Module.class, subjectId);
	
}




@Override
@Transactional
public void deleteModule(Module module) {
	ModuleBean mbean=new ModuleBean();
	System.out.println("Delete "+module.getSubjectid());
	//sessionFactory.getCurrentSession().createQuery("delete from Module where subjectid = "+module.getSubjectid()).executeUpdate();
	sessionFactory.getCurrentSession().delete(module.getSubjectid(), module);
	System.out.println();
}




@Override
@Transactional
public String UpdateModule(Module module,String subjectid) 
	{
	System.out.println(module.getSubjectid()+"this is update...........");
	String msg="FAIL";
	
	Session session = sessionFactory.getCurrentSession();
	try {
		//ModuleBean mbean =new ModuleBean();
		session.saveOrUpdate(subjectid, module);

		msg = "SUCCESS";
	} catch (Exception e) {
		
		System.out.println(e);
		msg = "INVALID_INPUT";
	}

	return msg;
}








}