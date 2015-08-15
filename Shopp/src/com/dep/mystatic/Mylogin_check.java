package com.dep.mystatic;

import android.app.Application;

public class Mylogin_check extends Application {
	
	static boolean login_check=false;

	public static boolean getLogin_check() {
		return login_check;
	}

	public static void setLogin_check(boolean login_check) {
		Mylogin_check.login_check = login_check;
	}
	

}
