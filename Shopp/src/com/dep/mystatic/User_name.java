package com.dep.mystatic;

import android.app.Application;

public class User_name extends Application {
	
	static String userinfo_name;


	public static String getUserinfo_name() {
		return userinfo_name;
	}


	public static void setUserinfo_name(String userinfo_name) {
		User_name.userinfo_name = userinfo_name;
	}


}
