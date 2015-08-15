package com.dep.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class sql_toos {
	 
	private Context cannet;
	
	
	  public sql_toos(Context cannet) {
		this.cannet = cannet;
	}


	  private MySqlHelp dbhelper = new MySqlHelp(cannet, "bookshopp.db", null, 1);

	  private SQLiteDatabase sqlbase=dbhelper.getWritableDatabase();

	  public String myselect(String sql){
	   
		  
	   
	return null;
	   
   }

}
