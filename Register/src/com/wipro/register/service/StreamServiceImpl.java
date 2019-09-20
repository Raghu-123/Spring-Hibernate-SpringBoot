package com.wipro.register.service;


	

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.register.dao.StreamDao;
import com.wipro.register.model.Stream;





	@Service(value=" streamService")
	
	
		public class StreamServiceImpl implements StreamService 
		{
	@Autowired
	StreamDao streamdao;
	


		@Override
		@Transactional
	public String addStream(Stream stream)
		{
			String msg="";
			
				String streamid=streamdao.generateId(stream.getStreamname(),"SEQ_STREAM_ID");
				stream.setStreamid(streamid);
				msg=streamdao.addstream(stream);
				if(msg.equalsIgnoreCase("success"))
				{
					
					msg="SUCCESS";
					System.out.println("this is success");
				}
			
			
			return msg;
		}


		
		@Transactional
		public List<Stream> listStreams() {
			
			return streamdao.liststreams();
		}

	@Transactional
		public Stream getStream(String streamid) {
			
			return streamdao.getstream(streamid);
		}


		
		
		public void deleteStream(Stream stream) {
			
			System.out.println(stream.getStreamid()+"this is service");
			streamdao.deletestream(stream);
			System.out.println(stream.getStreamid()+"this is service delete");
			
		}
		 public String updateStream(String streamid, Stream stream)
		 {
			return streamdao.updateStream(streamid, stream);
		 }



	
		}




	

