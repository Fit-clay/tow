package com.dep.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlHelp extends SQLiteOpenHelper {

	
	public MySqlHelp(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
             
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//用户信息表
	    String sql1="create table if not exists userinfo(username char(20),password char(20),sex char(20),address char(50),email char(30))";
            db.execSQL(sql1);
        //图书详细信息表                                                                                                       
    	    String sql2="create table if not exists bookinfo(id INTEGER PRIMARY KEY AUTOINCREMENT, bookname char(20),author char(20),eleprice char(20),entprice char(20),stock char(50),list_time char(50),image_path char(50))";
               db.execSQL(sql2);   
               //购物车
               String sql3="create table if not exists shopp_car(bookname char(20),author char(20),eleprice char(20),entprice char(20),image_path char(50))";
               db.execSQL(sql3);   
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
