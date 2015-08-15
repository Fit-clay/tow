package com.dep.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyUrl {
	
  public InputStream myurl(String url){
	 
	  
	  InputStream in = null;
	  try{
		  //�����ַ�������url
		  URL myurl=new URL(url);
		  //������
		  URLConnection uconn=myurl.openConnection();
		  //��ȡ������
		  in=uconn.getInputStream();
		 
		  
	  }catch(Exception e){e.printStackTrace();

}
	  finally{
		  return in;
	  }
}
}