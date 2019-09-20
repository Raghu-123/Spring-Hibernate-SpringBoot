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

import com.wipro.register.bean.ParticipantsBean;
import com.wipro.register.model.Participants;
import com.wipro.register.service.ParticipantsService;




@Controller
@SessionAttributes({ "sessionUser" })
public class ParticipantsController
{
	
	@Autowired
	ParticipantsService participantsService;
	
	

	@RequestMapping(value = "doparticipants", method = RequestMethod.GET)
	public ModelAndView Doparticipantsform(@ModelAttribute("command") ParticipantsBean pbean) {
		return new ModelAndView("Participants");

}
	
	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public ModelAndView addparticipants(@ModelAttribute("command") ParticipantsBean pbean,
			BindingResult result) 
	{
		System.out.println(pbean.getEmail());
		Participants participants= prepareModel(pbean);
		participantsService.addparticipants(participants);
		return new ModelAndView("redirect:/add2.html");
}
	
	@RequestMapping(value = "/participantslist", method = RequestMethod.GET)
	public ModelAndView viewPariticipants()
	
	{
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("modules  List being executed");
		model.put("participants", prepareListofparticipants(participantsService.Participants()));
		return new ModelAndView("participantslist",model);
	}
	

	@RequestMapping(value = "/add2", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") ParticipantsBean pbean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("participants",prepareListofparticipants(participantsService.Participants()) );
		return new ModelAndView("Participants",model);
}
	

	@RequestMapping(value = "/delete2", method = RequestMethod.GET)
	public ModelAndView editParticipants(@ModelAttribute("command")ParticipantsBean pbean ,BindingResult result)
			{
		System.out.println(pbean.getEmpid()+" ##########");
		//ModuleBean mbean=new ModuleBean();
		
		participantsService.deleteParticipants(prepareModel(pbean));
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("module", null);
		//System.out.println(mbean.getSubjectid());
		model.put("participants",prepareListofparticipants(participantsService.Participants()) );
		return new ModelAndView("Participants", model);
}
	
	
	@RequestMapping(value = "/update2", method = RequestMethod.POST)
	public ModelAndView deleteParticipants(@ModelAttribute("command")  ParticipantsBean pbean,
			BindingResult result) 
	{
		Participants part=new Participants();
		Map<String, Object> model = new HashMap<String, Object>();
		
		part.setBasl(pbean.getBasl());
		part.setEmail(pbean.getEmail());
		part.setEmpid(pbean.getEmpid());
		part.setName(pbean.getName());
		participantsService.UpdateParticipant(part.getEmpid(), part);
		model.put("participants",prepareListofparticipants(participantsService. Participants()) );
		return new ModelAndView("Participants", model);
		
	}

	@RequestMapping(value = "/edit2", method = RequestMethod.GET)
	public ModelAndView deleteparticipants(@ModelAttribute("command")  Participants pbean,
			BindingResult result) 
	{
		System.out.println(pbean.getEmpid()+"##########");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("participant",prepareparticipantsBean(participantsService. getParticipants(pbean.getEmpid())));
		model.put("participants",prepareListofparticipants(participantsService. Participants()) );
		return new ModelAndView("updateparticipant", model);
		
}
	

	private ParticipantsBean prepareparticipantsBean(Participants participantsBean)
	{
		ParticipantsBean pbean=new ParticipantsBean();
		pbean.setEmpid(participantsBean.getEmpid());
		pbean.setName(participantsBean.getName());
		pbean.setBasl(participantsBean.getBasl());
		pbean.setEmail(participantsBean.getEmail());
		
		return pbean;
		
	}

	private Participants prepareModel(ParticipantsBean pbean) 
	{
		Participants participants=new Participants();
		
		//mbean.setSubjectid(module.getSubjectid());
		participants.setEmpid(pbean.getEmpid());
		participants.setName(pbean.getName());
		participants.setBasl(pbean.getBasl());
		participants.setEmail(pbean.getEmail());
		
		return participants;
}
	
	private List<ParticipantsBean> prepareListofparticipants(List<Participants> participants) {
		List<ParticipantsBean> pbean = null;

		if (participants != null && !participants.isEmpty()) {

			pbean = new ArrayList<ParticipantsBean>();

			ParticipantsBean pbean1 = null;
			for (Participants module: participants) {
				pbean1 = new ParticipantsBean();
				pbean1.setEmpid(module.getEmpid());
				pbean1.setName(module.getName());
				pbean1.setBasl(module.getBasl());
				pbean1.setEmail(module.getEmail());
				
				pbean.add(pbean1);
			}
		}
		return pbean;
}
}