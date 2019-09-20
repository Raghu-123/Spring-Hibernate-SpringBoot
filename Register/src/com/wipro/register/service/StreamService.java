package com.wipro.register.service;

import java.util.List;

import com.wipro.register.model.Stream;



public interface StreamService {

	public String addStream(Stream stream);
	 //boolean isChanged(String subjectid, String subjecttitle);
		public List<Stream> listStreams();
		public Stream getStream(String streamid);
		public void deleteStream(Stream stream);
		 public String updateStream(String streamid, Stream stream);
	}


