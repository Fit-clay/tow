package com.dep.mystatic;

import android.app.Application;

public class User_id extends Application {
		
		static int id;

		public static int getLogin_check() {
			return id;
		}

		public static void setId(int id) {
			User_id.id = id;
		}

}
