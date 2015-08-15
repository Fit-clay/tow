package com.dep.mystatic;

import android.app.Application;

public class Book_Name extends Application {
	
	static private String book_Name;

	public static String getBook_Name() {
		return book_Name;
	}

	public static void setBook_Name(String book_Name) {
		Book_Name.book_Name = book_Name;
	}

}
