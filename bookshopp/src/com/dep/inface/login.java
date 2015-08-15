package com.dep.inface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dep.javabean.userinfo;
public class login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(username+""+password);
		System.out.println();
		Dconn dconn=new Dconn();
		Connection conn=dconn.Myconn();
		String sql = "select id,username,password from userinfo";		
		Statement stmt;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);	
			
			List<userinfo> list = new ArrayList<userinfo>();		

			
			while(rs.next()){		
				userinfo user=new userinfo();
				user.setUsername(rs.getString("username"));
				user.setUserpasswd(rs.getString("password"));
				user.setUser_id(rs.getInt("id"));
                  list.add(user);
			}
			
			PrintWriter out = response.getWriter();
			for(int i=0;i<list.size();i++){
			
				String sqlname = list.get(i).getUsername();
				String sqlpasswd=list.get(i).getUserpasswd();
				
				System.out.println(sqlname+""+sqlpasswd);
			if(username.equals(sqlname)&&password.equals(sqlpasswd)){
				out.print("登陆成功"+".");
				out.print(list.get(i).getUser_id());
				System.out.println("登录成功");
				
				stmt.close();
				conn.close();
				
				out.flush();
				out.close();
				return;
			}
			
			}
			
				out.print("登录失败");
			System.out.println("登录失败");
		
			stmt.close();
			conn.close();
			out.flush();
			out.close();
			
			
			
			
				
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
