package com.wipro.register.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;







import com.wipro.register.bean.ModuleBean;
import com.wipro.register.bean.PhaseBean;
import com.wipro.register.model.Module;
import com.wipro.register.model.Phase;
import com.wipro.register.service.ModuleService;
import com.wipro.register.service.PhaseService;

@Controller
@SessionAttributes({ "sessionUser" })
public class AdminController {

	@Autowired
	ModuleService moduleService;
	
	@Autowired
	PhaseService phaseservice;
	
	


	@RequestMapping(value = "domodule", method = RequestMethod.GET)
	public ModelAndView Domoduleform(@ModelAttribute("command") ModuleBean mbean) {
		return new ModelAndView("addmodule");

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView addmodule(@ModelAttribute("command") ModuleBean mbean,
			BindingResult result) {
		Module module= prepareModel(mbean);
		moduleService.addmodule(module);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/modules", method = RequestMethod.GET)
	public ModelAndView viewmodule()
	
	{
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("modules  List being executed");
		model.put("modules", prepareListofBean(moduleService.listModules()));
		return new ModelAndView("modulelist",model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") ModuleBean mbean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("modules",prepareListofBean(moduleService.listModules()) );
		return new ModelAndView("addmodule",model);
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deletemodule(@ModelAttribute("command")ModuleBean mbean ,BindingResult result)
			{

	
		moduleService.deletemodule(prepareModel(mbean));
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("module", null);
		model.put("modules",prepareListofBean(moduleService.listModules()) );
		return new ModelAndView("addmodule", model);
			}
	

	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
public ModelAndView updatemodule(@ModelAttribute("command")  ModuleBean mbean,
		BindingResult result) 
	{
		Module module=new Module();
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println(module.getSubjectid()+"##############################"+mbean.getSubjectid());
		//model.put("mbean",prepareModel(mbean));
		
		module.setSubjectid(mbean.getSubjectid());
		module.setComments(mbean.getComments());
		module.setDescription(mbean.getDescription());
		module.setDuration(mbean.getDuration());
		module.setSubjecttitle(mbean.getSubjecttitle());
		System.out.println(moduleService.UpdateModule(module,module.getSubjectid()));
		
		model.put("modules",prepareListofBean(moduleService.listModules()) );
		return new ModelAndView("addmodule", model);
		
		
	}
	
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editmodule(@ModelAttribute("command")  ModuleBean mbean,
			BindingResult result) 
	{
		Module module=new Module();
		System.out.println("this is edit"+mbean.getSubjectid());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("module",prepareModuleBean(moduleService.getmodule(mbean.getSubjectid())));
		//moduleService.UpdateModule(module);
		model.put("modules",prepareListofBean(moduleService.listModules()) );
		
		return new ModelAndView("updatemodule", model);
	
	}

	
	private ModuleBean prepareModuleBean(Module module)
	{
		ModuleBean mbean=new ModuleBean();
		mbean.setSubjectid(module.getSubjectid());
		mbean.setSubjecttitle(module.getSubjecttitle());
		mbean.setDescription(module.getDescription());
		mbean.setComments(module.getComments());
		mbean.setDuration(module.getDuration());
		return mbean;
		
	}
	
	

	private Module prepareModel(ModuleBean mbean) 
	{
		Module module=new Module();
		
		//mbean.setSubjectid(module.getSubjectid());
		module.setSubjectid(mbean.getSubjectid());
		module.setSubjecttitle(mbean.getSubjecttitle());
		module.setComments(mbean.getComments());
		module.setDescription(mbean.getDescription());
		module.setDuration(mbean.getDuration());
		return module;
	}

	
	private List<ModuleBean> prepareListofBean(List<Module> modules) {
		List<ModuleBean> mbean = null;

		if (modules != null && !modules.isEmpty()) {

			mbean = new ArrayList<ModuleBean>();

			ModuleBean mbean1 = null;
			for (Module module: modules)
			{
				mbean1 = new ModuleBean();
				mbean1.setSubjectid(module.getSubjectid());
				mbean1.setSubjecttitle(module.getSubjecttitle());
				mbean1.setDescription(module.getDescription());
				mbean1.setComments(module.getComments());
				mbean1.setDuration(module.getDuration());
				mbean.add(mbean1);
			}
		}
		return mbean;

	}
	
	
	
	@RequestMapping(value="getphaseform",method=RequestMethod.GET)
	public ModelAndView getphaseAdd(@ModelAttribute("command") PhaseBean phasebean)
	{
		return new ModelAndView("addphase");
	}
	@RequestMapping(value="dophaseform",method=RequestMethod.POST)
	public ModelAndView dophaseAdd(@ModelAttribute("command") PhaseBean phasebean)
	{
		String msg="FAIL";
		System.out.println(phasebean.getRemarks());
		ModelAndView mv=new ModelAndView();
		Phase phase=prepareModel(phasebean);
		System.out.println(phase.getRemarks());
		Map<String, Object> model = new HashMap<String, Object>();
		if (phasebean!=null && !phasebean.getAssessmentDate().equals("") && phasebean.getDuration()!=0 && !phasebean.getPhasedescription().equals(null) && !phasebean.getRemarks().equals(null)) {
			
		
		
			msg=phaseservice.addphase(phase);
			if (msg.equalsIgnoreCase("SUCCESS")) 
			{
				mv= new ModelAndView("redirect:/add1.html");
			}
		}
		else
		{
			mv=new ModelAndView("addphase","msg","Some fields are missing!!");
		}
		
		return mv;
	}
	@RequestMapping(value="/phases", method = RequestMethod.GET)
	public ModelAndView listEmployees() 
	{
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("Employees List being executed");
		model.put("phases",  prepareListofphase(phaseservice.listPhase()));
		return new ModelAndView("phaselist", model);
	}

	
	@RequestMapping(value = "/add1", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  PhaseBean phasebean,BindingResult result) 
	{
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("Add new Employee to List - executed");
		model.put("phases",  prepareListofphase(phaseservice.listPhase()));
		return new ModelAndView("addphase", model);
	}


	

	@RequestMapping(value = "/delete1", method = RequestMethod.GET)
	public ModelAndView deletePhase(@ModelAttribute("command")  PhaseBean phasebean,BindingResult result) 
	{
		
		
		
		
		phaseservice.deletePhase(prepareModel(phasebean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("phase", null);
		model.put("phases",  prepareListofphase(phaseservice.listPhase()));
		return new ModelAndView("addphase", model);
	}
	

	@RequestMapping(value = "/update1", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("command")  PhaseBean phasebean,BindingResult result) 
	{
		Phase phase=new Phase();
		Map<String, Object> model = new HashMap<String, Object>();
		phase.setPhaseid(phasebean.getPhaseid());
		phase.setPhaseDescription(phasebean.getPhasedescription());
		phase.setAssessmentDate(phasebean.getAssessmentDate());
		phase.setDuration(phasebean.getDuration());
		phase.setRemarks(phasebean.getRemarks());
		System.out.println(phase.getPhaseid());
		phaseservice.updatePhase(phase, phase.getPhaseid());
		//model.put("phase", preparePhaseBean(phaseservice.getPhase(phasebean.getPhaseid())));
		model.put("phases",  prepareListofphase(phaseservice.listPhase()));
		return new ModelAndView("addphase", model);
	}

	@RequestMapping(value = "/edit1", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  PhaseBean phasebean,BindingResult result) 
	{
		Phase phase=new Phase();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("phase", preparePhaseBean(phaseservice.getPhase(phasebean.getPhaseid())));
			model.put("phases",  prepareListofphase(phaseservice.listPhase()));
			return new ModelAndView("updatephase", model);
		}



	private Phase prepareModel(PhaseBean phasebean){
		Phase phase = new Phase();
		phase.setPhaseid(phasebean.getPhaseid());
		phase.setPhaseDescription(phasebean.getPhasedescription());
		phase.setAssessmentDate(phasebean.getAssessmentDate());
		phase.setDuration(phasebean.getDuration());
		phase.setRemarks(phasebean.getRemarks());
		//phasebean.setPhaseid(phase.getPhaseid());
		
		//phasebean.setPhaseid(null);
		return phase;
	}

	private List<PhaseBean> prepareListofphase(List<Phase> phases){
		List<PhaseBean> beans = null;
		if(phases != null && !phases.isEmpty()){
			beans = new ArrayList<PhaseBean>();
			PhaseBean bean = null;
			for(Phase phase : phases)
			{
				bean = new PhaseBean();
				bean.setPhaseid(phase.getPhaseid());;
				bean.setPhasedescription(phase.getPhaseDescription());
				bean.setAssessmentDate(phase.getAssessmentDate());
				
				bean.setDuration(phase.getDuration());
				bean.setRemarks(phase.getRemarks());;
				
				beans.add(bean);
			}
		}
		return beans;
	}

	private PhaseBean preparePhaseBean(Phase phase){
		PhaseBean phasebean = new PhaseBean();
		phasebean.setPhaseid(phase.getPhaseid());;
		phasebean.setPhasedescription(phase.getPhaseDescription());
		phasebean.setAssessmentDate(phase.getAssessmentDate());
		phasebean.setDuration(phase.getDuration());
		phasebean.setRemarks(phase.getRemarks());
		return phasebean;
	}
	

	
}






	
	

