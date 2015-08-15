package com.dep.inface;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dconn {
	
	public Connection Myconn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shopp";// 数据库连接字符串
			String username = "root";								// 数据库用户名
			String password = "";								// 数据库密码
		    conn = DriverManager.getConnection(url,username,password); 		// 创建Connection连接
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return conn;
		}
		
	}

}
