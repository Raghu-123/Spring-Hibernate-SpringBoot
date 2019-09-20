package com.wipro.register.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.register.bean.CredentialsBean;
import com.wipro.register.bean.ModuleBean;
import com.wipro.register.bean.ProfileBean;
import com.wipro.register.service.Authentication;
import com.wipro.register.service.ModuleService;
import com.wipro.register.service.User;

@Controller
@SessionAttributes({ "sessionUser" })
public class UserController {

	@Autowired
	User user;

	@Autowired
	Authentication authentication;


	@RequestMapping(value = "getregisterform", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm(
			@ModelAttribute("userProfile") ProfileBean profile) {
		return new ModelAndView("registerUser");
	}

	@RequestMapping(value = "doRegistration", method = RequestMethod.POST)
	public ModelAndView doRegistration(@ModelAttribute("userProfile") ProfileBean profile) {
		ModelAndView mav=new ModelAndView("registerUser", "msg", "Sorry Unable to register now");
		
		String newUserId = user.register(profile);
		
		if (newUserId!=null && !newUserId.equalsIgnoreCase("FAIL")) {
			String response="userid id is: "+newUserId;
			mav=new ModelAndView("success", "msg", response);
		} 
		return mav;
		
	}

	@RequestMapping(value = "/getloginform", method = RequestMethod.GET)
	public ModelAndView getLoginForm(
			@ModelAttribute("cbean") CredentialsBean cbean) {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "dologinform", method = RequestMethod.POST)
	public ModelAndView doLoginForm(
			@ModelAttribute("cbean") @Valid CredentialsBean cbean,
			BindingResult result) {
		ModelAndView mv = new ModelAndView("fail", "msg",
				"Form validation FAILED!!!!!!");

		if (result.hasErrors()) {
			mv = new ModelAndView("login");
		} 
		else
		{
			String userLogType=user.login(cbean);
			if(userLogType.equalsIgnoreCase("A"))
			{
				mv=new ModelAndView("admin","msg","successfuly loggedin");
				mv.addObject("sessionUser",cbean.getUserid());
			}
			else if(userLogType.equalsIgnoreCase("U")){
				mv=new ModelAndView("custmer","msg","successfuly loggedin");
				mv.addObject("sessionUser",cbean.getUserid());
				
			}
			else {
				mv = new ModelAndView("login", "msg",
						"invalid username and password");
			}
		}
		
		return mv;

	}

	@RequestMapping(value = "/getchangeform", method = RequestMethod.GET)
	public ModelAndView getchange(@ModelAttribute("cbean") CredentialsBean cbean) {
		
		return new ModelAndView("ChangePassword");
	}

	@RequestMapping(value = "u", method = RequestMethod.POST)
	public ModelAndView doChange(@ModelAttribute("cbean") CredentialsBean cbean,@ModelAttribute("sessionUser") String id) {
		boolean flag = false;
		//id=cbean.getUserid();
		CredentialsBean cb=new CredentialsBean();
		cb.setUserid(id);
		cbean.setUserid(cb.getUserid());
		System.out.println("#######"+cbean.getUserid());
		flag = user.isPasswordChanged(cbean,
				cbean.getNewpassword());
		if (flag == true) 
		{
			System.out.println("inside authenticate");
			return new ModelAndView("login", "msg",
					"Changed password Successfully");
		} else {
			return new ModelAndView("ChangePassword", "msg",
					"Something went wrong password cannot be changed!!");
		}
	}

	@RequestMapping(value = "getlogoutform", method = RequestMethod.GET)
	public ModelAndView doLogoutForm(@ModelAttribute("sessionUser") String id,@ModelAttribute("cbean") CredentialsBean cbean) {
		System.out.println(" controller being executed.....");
		System.out.println(id);
		//CredentialsBean bean = new CredentialsBean();
		cbean.setUserid(id);
		

		boolean msg = false;

		if (user.isOut(cbean)) 
		{
			System.out.println("Successfully logged out");
			return new ModelAndView("login", "msg",
					"Successfully logged out ----");
		} else {
			System.out.println("Sorry not logged out");
			return new ModelAndView("custmer", "msg", "Problem in logout");
		}

	}
	
	
	@RequestMapping(value = "gotoback", method = RequestMethod.GET)
	public ModelAndView getmainForm(
			@ModelAttribute("userProfile") ProfileBean profile) {
		return new ModelAndView("admin");
	}
	
	@RequestMapping(value = "gotocback", method = RequestMethod.GET)
	public ModelAndView getcustomermainForm(
			@ModelAttribute("command") ProfileBean profile) {
		return new ModelAndView("custmer");
	}

}
