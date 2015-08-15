package com.dep.inface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class save_userinfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public save_userinfo() {
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
		PrintWriter out = response.getWriter();
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("GBK");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String sex=request.getParameter("sex");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String id=request.getParameter("id");
          int myid=Integer.valueOf(id);
		String sql = "update userinfo set username="
				+"'"+username+"',"+"password="+"'"+password+"',"+"sex="+"'"+sex+"',"+"address="+"'"+address+"',"+"email="+"'"+email+"'"+" where id="+myid;
					System.out.println(sql);
		Dconn dconn=new Dconn();
		Connection conn=dconn.Myconn();

		try{
			Statement stmt=conn.createStatement();	
			if(stmt.executeUpdate(sql)>0){
				out.print("修改成功");
				System.out.println("ok");
			}
			else {
				out.print("修改失败");
				System.out.println("no");

			}
			
			stmt.close();
			conn.close(); 
			
			out.flush();
			out.close();
		}
		catch(Exception e){e.printStackTrace();}
	
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
