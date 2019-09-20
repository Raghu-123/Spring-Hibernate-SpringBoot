package com.wipro.register.service;

import java.util.List;
import com.wipro.register.model.*;



public interface ParticipantsService

{
	

	String addparticipants(Participants Participants);
 //boolean isChanged(String subjectid, String subjecttitle);
	public List<Participants> Participants();
	public Participants getParticipants(String empid);
	public void deleteParticipants(Participants Participants);
	 String UpdateParticipant(String empid,Participants Participants);

}
