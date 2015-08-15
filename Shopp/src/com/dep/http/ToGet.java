package com.dep.http;

import java.util.Map;

public class ToGet {

	public String  toget(String path, Map<String, String> map){
		
		StringBuffer url=new StringBuffer(path);
		   url.append("?");
			for(Map.Entry<String, String> entry:map.entrySet()){
				url.append(entry.getKey());
				url.append("=");
				url.append(entry.getValue());
				url.append("&");
				
			}
			url.deleteCharAt(url.length()-1);
		
		
		return url.toString();
		
	}
}
