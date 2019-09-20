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

import com.wipro.register.bean.StreamBean;
import com.wipro.register.model.Stream;
import com.wipro.register.service.StreamService;


	@Controller
	@SessionAttributes({ "sessionUser" })
	public class Streamcontroller 
	{

		@Autowired
		StreamService streamService;
		@RequestMapping(value = "dostream1", method = RequestMethod.GET)
		public ModelAndView streamform(@ModelAttribute("command") StreamBean mbean) {
			return new ModelAndView("addstream");

		}

		@RequestMapping(value = "/save3", method = RequestMethod.POST)
		public ModelAndView addstream1(@ModelAttribute("command") StreamBean mbean,
				BindingResult result) {
			Stream stream= prepareModel(mbean);
			streamService.addStream(stream);
			return new ModelAndView("redirect:/add3.html");
		}

		@RequestMapping(value = "/dostreamlist", method = RequestMethod.GET)
		public ModelAndView Streamlist()
		
		{
			Map<String, Object> model = new HashMap<String, Object>();
		//	System.out.println("modules  List being executed");
			model.put("streams", prepareListofstream(streamService.listStreams()));
			return new ModelAndView("streamlist",model);
		}

		
		@RequestMapping(value = "/add3", method = RequestMethod.GET)
		public ModelAndView addStream(@ModelAttribute("command") StreamBean mbean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
			model.put("streams",prepareListofstream(streamService.listStreams()) );
			return new ModelAndView("addstream",model);
		}
		
		
		@RequestMapping(value = "/delete3", method = RequestMethod.GET)
		public ModelAndView editStream(@ModelAttribute("command")StreamBean sbean ,BindingResult result)
				{
			System.out.println(sbean.toString()+"bhargfacavava");
			
			streamService.deleteStream(prepareModel(sbean));
			Map<String, Object> model = new HashMap<String, Object>();

			model.put("stream", null);
			//System.out.println(mbean.getSubjectid());
			model.put("streams",prepareListofstream(streamService.listStreams()) );
			return new ModelAndView("addstream", model);
				}
		
		
		@RequestMapping(value = "/update3", method = RequestMethod.POST)
		public ModelAndView updateStream(@ModelAttribute("command") StreamBean mbean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		Stream stream=new Stream();
		stream.setComments(mbean.getComments());
		stream.setStreamdetails(mbean.getStreamdetails());
		stream.setStreamid(mbean.getStreamid());
		stream.setStreamname(mbean.getStreamname());
		//System.out.println(stream.getStreamid());
		streamService.updateStream(stream.getStreamid(), stream);
	//	System.out.println(stream.getStreamid()+"nbfdhjvbdshgvhjdsb");
			model.put("streams",prepareListofstream(streamService.listStreams()) );
			return new ModelAndView("addstream",model);
		}
		
		
		@RequestMapping(value = "/edit3", method = RequestMethod.GET)
		public ModelAndView deleteStream(@ModelAttribute("command")  Stream mbean,
				BindingResult result) 
		{
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("stream",prepareStreamBean(streamService.getStream(mbean.getStreamid())));
			model.put("streams",prepareListofstream(streamService.listStreams()) );			
			return new ModelAndView("UpdateStream",model);
		
	}
		
		
		private StreamBean prepareStreamBean(Stream stream)
		{
			StreamBean mbean=new StreamBean();
             mbean.setStreamid(stream.getStreamid());
             mbean.setStreamdetails(stream.getStreamdetails());
             mbean.setComments(stream.getComments());
             mbean.setStreamname(stream.getStreamname());
			return mbean;
			
		}
		

		private Stream prepareModel(StreamBean mbean) 
		{
			Stream stream=new Stream();
			
		System.out.println(mbean.getStreamid()+"this is prepare model");
	
			stream.setStreamid(mbean.getStreamid());
			stream.setComments(mbean.getComments());
			stream.setStreamdetails(mbean.getStreamdetails());
			stream.setStreamname(mbean.getStreamname());
			
			//System.out.println(mbean.toString());
			System.out.println(mbean.getStreamname());
		
			return stream;
		}

		
		private List<StreamBean> prepareListofstream(List<Stream> streams) {
			List<StreamBean> mbean = null;

			if (streams != null && !streams.isEmpty()) {

				mbean = new ArrayList<StreamBean>();

				StreamBean mbean1 = null;
				for (Stream stream: streams) {
					mbean1 = new StreamBean();
					mbean1.setComments(stream.getComments());
					mbean1.setStreamdetails(stream.getStreamdetails());
					mbean1.setStreamid(stream.getStreamid());
					mbean1.setStreamname(stream.getStreamname());
					mbean.add(mbean1);
				}
			}
			return mbean;

		}
	

	}


