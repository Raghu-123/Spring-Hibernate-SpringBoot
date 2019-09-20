package com.wipro.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.register.dao.PhaseDao;
import com.wipro.register.model.Phase;



@Service(value="phaseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PhaseServiceImpl implements PhaseService
{
	@Autowired
	PhaseDao phasedao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	
	public String addphase(Phase phase) {
		String msg=" ";
		String s1=phasedao.generateUserId("phase_seq");
		phase.setPhaseid(s1);
		System.out.println(phase.getRemarks());
		msg=phasedao.addPhase(phase);
		return msg;
	}

	@Override
	public List<Phase> listPhase() {
		// TODO Auto-generated method stub
		return phasedao.listPhases();
		
	}

	@Override
	public void deletePhase(Phase phase) {
		// TODO Auto-generated method stub
		phasedao.deletePhase(phase);
		
	}

	@Override
	public Phase getPhase(String id) {
		// TODO Auto-generated method stub
		return phasedao.getPhase(id);
		
	}

	@Override
	public String updatePhase(Phase phase, String phaseid) {
		// TODO Auto-generated method stub
		return phasedao.updatePhase(phase, phaseid);
		
	}

}
