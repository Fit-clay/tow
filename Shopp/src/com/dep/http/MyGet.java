package com.dep.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class MyGet {

	public String myget(String str) {
				try {
					
					
					
					HttpGet httpget = new HttpGet(str);
					// ʵ��httpclient�ӿ�
					HttpClient httpclient = new DefaultHttpClient();
					// ����HttpResponse����
					HttpResponse httpResponse;

					httpResponse = httpclient.execute(httpget);

					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String result = EntityUtils.toString(httpResponse
								.getEntity(),"UTF-8");
						
                             System.out.println(result); 
                             
                     		return result;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		return "登陆失败";

	}

}
