package com.dep.inface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public register() {
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

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("GBK");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String sex=request.getParameter("sex");
		System.out.println(sex);
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		PrintWriter out = response.getWriter();
try{
		String sql = "insert into userinfo(username,password,sex,address,email) values(?,?,?,?,?)";	// 添加图书信息的SQL语句
		
		Dconn dconn=new Dconn();
		Connection conn=dconn.Myconn();
		PreparedStatement ps = conn.prepareStatement(sql); // 获取PreparedStatement
		
		
		
		ps.setString(1, username);			// 对SQL语句中的第1个参数赋值
		ps.setString(2, password);			// 对SQL语句中的第2个参数赋值
		ps.setString(3, sex);			// 对SQL语句中的第4个参数赋值
		ps.setString(4,address);			// 对SQL语句中的第4个参数赋值
		ps.setString(5, email);			// 对SQL语句中的第4个参数赋值
		
		int row = ps.executeUpdate();				// 执行更新操作，返回所影响的行数

		if(row>0){
			out.print("注册成功");
			System.out.print("注册成功");
		}
		else
		{			
			out.print("注册失败");

			System.out.print("注册失败");
		}
		ps.close();							// 关闭PreparedStatement，释放资源
		conn.close();
		out.flush();
		out.close();
}
catch(Exception e){e.printStackTrace();}
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

doGet(request, response);
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
