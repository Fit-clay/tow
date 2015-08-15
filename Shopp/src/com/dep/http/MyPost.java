package com.dep.http;

import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Entity;
import android.provider.Settings.NameValueTable;

public class MyPost {

	public String mydopost(String uri,List<NameValuePair> parameters)  {
	HttpPost post=new HttpPost(uri);
	try{
		
		//���ò�������
	 HttpEntity entity=new UrlEncodedFormEntity(parameters,"utf-8");
	//request����	
	 post.setEntity(entity);
		HttpClient httpclient=new DefaultHttpClient();
		//����HttpRespone
		HttpResponse httpresponse=httpclient.execute(post);
		//�ж��Ƿ����ӳɹ�
		if(httpresponse.getStatusLine().getStatusCode()==200){
			
			String result=EntityUtils.toString(httpresponse.getEntity());
			String str=new String(result.getBytes("utf-8"),"utf-8");
		  return str;
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return "lose";
	}
}
