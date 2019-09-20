package com.wipro.register.dao;

import java.util.List;

import com.wipro.register.model.Phase;



public interface PhaseDao
{
	
	public String generateUserId(String seqName) ;
	public String addPhase(Phase phase);
	public String updatePhase(Phase phase,String phaseid);
	public List<Phase> listPhases();
	
	public Phase getPhase(String id);
	
	public void deletePhase(Phase phase);

}
