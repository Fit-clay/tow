package com.dep.mystatic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Application;

public class My_image extends Application {
	private static ArrayList<Map<String, Object>> myimg=new ArrayList<Map<String,Object>>();

	public static ArrayList<Map<String, Object>> getMyimg() {
		return myimg;
	}

	public static void setMyimg(ArrayList<Map<String, Object>> myimg) {
		My_image.myimg = myimg;
	}


	
}
