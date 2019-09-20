
package com.wipro.register.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wipro.register.model.Participants;

import com.wipro.register.dao.ParticipantsDao;



@Service(value=" participantsService")
public class ParticipantsServiceImpl implements ParticipantsService
{
	@Autowired
	ParticipantsDao participantsDao;

	@Override
	@Transactional
	public String addparticipants(Participants participants)
	{
		
		String msg="";
		System.out.println(participants.getEmail());
		String subjectid=participantsDao.generateId(participants.getName(),"seq_name");
		participants.setEmpid(subjectid);
		msg=participantsDao.addparticipants(participants);
		if(msg.equalsIgnoreCase("success"))
		{
			
			msg="SUCCESS";
			System.out.println("this is success");
		}
	
	
	return msg;
}

	
	@Override
	@Transactional
	public List<Participants> Participants()
	{
		return participantsDao.listparticipants();
		
	}

	@Transactional
	public Participants getParticipants(String empid) {
		
		return participantsDao.getParticipants(empid);
	}


	@Override
	@Transactional
	public void deleteParticipants(Participants participants) {
		participantsDao.deleteParticipants(participants);

	
	}


	@Override
	@Transactional
	public String UpdateParticipant(String empid,Participants Participants) {
	
		return  participantsDao.UpdateParticipant(empid, Participants);
	}
	
	
		
	}
	


