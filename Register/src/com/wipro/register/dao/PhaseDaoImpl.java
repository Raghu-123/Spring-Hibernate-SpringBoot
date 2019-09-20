package com.wipro.register.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.register.bean.PhaseBean;
import com.wipro.register.model.Phase;


@Repository(value="phaseDao")
public class PhaseDaoImpl implements PhaseDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public String generateUserId(String seqName) 
	{
		String result = "FAIL";
		
		if(seqName!=null){
		Connection connection=(Connection) sessionFactory.getCurrentSession();
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet resultSet = stmt
						.executeQuery("Select "+seqName+".nextval from dual");
				if (resultSet.next()) 
				{
					result = resultSet.getString(1);
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
	
	
	@Override
	@Transactional
	public String addPhase(Phase phase) {
		// TODO Auto-generated method stub
		String msg=" FAIL";
		PhaseBean pb=new PhaseBean();
		System.out.println(phase.getRemarks());
		
System.out.println(phase.getPhaseid()+"!!!!!"+pb.getPhaseid());
		
		System.out.println(phase.getPhaseDescription()+"!!675!!!"+pb.getPhasedescription());
		if (phase!=null)
		{
			
		
		sessionFactory.getCurrentSession().saveOrUpdate(phase);
		msg="SUCCESS";
		System.out.println("executing");
		
		}
		
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Phase> listPhases() 
	{
		// TODO Auto-generated method stub
		return (List<Phase>) sessionFactory.getCurrentSession().createCriteria(Phase.class).list();
		
	}

	@Override
	@Transactional
	public Phase getPhase(String id)
	{
		
		
		// TODO Auto-generated method stub
		return (Phase) sessionFactory.getCurrentSession().get(Phase.class, id);
		
	}

	@Override
	@Transactional
	public void deletePhase(Phase phase)
	{
		
		// TODO Auto-generated method stub
		//sessionFactory.getCurrentSession().createQuery("DELETE FROM Phase WHERE phaseid = "+phase.getPhaseid()).executeUpdate();
		sessionFactory.getCurrentSession().delete(phase.getPhaseid(), phase);
	}


	@Override
	@Transactional
	public String updatePhase(Phase phase,String phaseid)
	{
		String msg=" FAIL";
		PhaseBean pb=new PhaseBean();
		System.out.println(phase.getRemarks());
		
System.out.println(phase.getPhaseid()+"!!!!!"+pb.getPhaseid());
		
		System.out.println(phase.getPhaseDescription()+"!!675!!!"+pb.getPhasedescription());
		if (phase!=null)
		{
			
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(phaseid,phase);
			msg="SUCCESS";
			System.out.println("executing");
		} catch (HibernateException e) {
			msg="INVALID";
		}
		
		}
		
		return msg;
	}

}
