package com.wipro.register.dao;
import java.util.List;

import com.wipro.register.model.Stream;





public interface StreamDao
{






 String addstream(Stream stream);
 List<Stream> liststreams();
 String generateId(String streamname,String seqName);
// boolean isUpdated(String streamId,String streamname);
 public Stream getstream(String streamId);
 public void deletestream(Stream stream);
 public String updateStream(String streamid, Stream stream);

}


