package com.wipro.register.dao;

import java.util.List;

import com.wipro.register.bean.ModuleBean;
import com.wipro.register.model.Module;

public interface ModuleDao 
{
 String addmodule(Module module);
 List<Module> listmodules();
 String generateId(String subjecttitle,String seqName);
// boolean isUpdated(String subjectId,String subjectname);
 public Module getModule(String subjectId);
 public void deleteModule(Module module);
 String UpdateModule(Module module,String subjectid);

}
