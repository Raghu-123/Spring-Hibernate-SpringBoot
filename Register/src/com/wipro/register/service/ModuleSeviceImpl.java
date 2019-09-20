package com.wipro.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.register.bean.ModuleBean;
import com.wipro.register.dao.ModuleDao;
import com.wipro.register.model.Module;

@Service(value=" moduleService")
public class ModuleSeviceImpl implements  ModuleService
{
@Autowired
ModuleDao Moduledao;


	@Override
	@Transactional
	public String addmodule(Module module) 
	{
		String msg="";
		
			String subjectid=Moduledao.generateId(module.getSubjecttitle(),"SEQ_SUBJECT_ID");
			module.setSubjectid(subjectid);
			msg=Moduledao.addmodule(module);
			if(msg.equalsIgnoreCase("success"))
			{
				
				msg="SUCCESS";
				System.out.println("this is success");
			}
		
		
		return msg;
	}


	@Override
	@Transactional
	public List<Module> listModules() {
		
		return Moduledao.listmodules();
	}

@Transactional
	public Module getmodule(String subjectId) {
		
		return Moduledao.getModule(subjectId);
	}


	@Override
	@Transactional
	public void deletemodule(Module module) {
		
		Moduledao.deleteModule(module);
		
	}


	@Override
	@Transactional
	public String UpdateModule(Module module,String subjectid) {
		
		return Moduledao.UpdateModule(module,subjectid);
	}



	
	

}
