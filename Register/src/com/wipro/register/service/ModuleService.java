package com.wipro.register.service;

import java.util.List;

import com.wipro.register.bean.ModuleBean;
import com.wipro.register.model.Module;

public interface ModuleService 
{

	String addmodule(Module module);
 //boolean isChanged(String subjectid, String subjecttitle);
	public List<Module> listModules();
	public Module getmodule(String subjectId);
	public void deletemodule(Module module);
	 String UpdateModule(Module module,String subjectid);
}

