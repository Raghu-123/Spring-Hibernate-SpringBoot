package com.wipro.register.dao;

import java.util.List;

import com.wipro.register.model.Participants;



public interface ParticipantsDao 
{

	 String addparticipants(Participants Participants);
	 List<Participants> listparticipants();
	 String generateId(String name,String seqName);
	// boolean isUpdated(String subjectId,String subjectname);
	 public Participants getParticipants(String empId);
	 public void deleteParticipants(Participants participants);
	 String UpdateParticipant(String empid,Participants Participants);

	
}
