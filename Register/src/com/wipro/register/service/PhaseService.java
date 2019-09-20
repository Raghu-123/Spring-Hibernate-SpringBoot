package com.wipro.register.service;

import java.util.List;

import com.wipro.register.model.Phase;

public interface PhaseService
{
String addphase(Phase phase);
public List<Phase> listPhase();
public Phase getPhase(String id);
public void deletePhase(Phase phase);
String updatePhase(Phase phase,String phaseid);
}
