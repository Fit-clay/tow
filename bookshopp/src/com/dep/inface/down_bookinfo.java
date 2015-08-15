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

import net.sf.json.JSONArray;

import com.dep.javabean.Bookinfo;

public class down_bookinfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public down_bookinfo() {
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
		PrintWriter out = response.getWriter();
		
        System.out.println("1");

		try{
			Dconn dconn=new Dconn();
			Connection conn=dconn.Myconn();
			String sql = "select * from bookinfo";	
			Statement stmt = conn.createStatement();		

			ResultSet rs = stmt.executeQuery(sql);
			
	        System.out.println("2");

			
			List<Bookinfo> list = new ArrayList<Bookinfo>();		
	          while(rs.next())
	          {
	        	  Bookinfo book=new Bookinfo();
	        	  book.setBookname(rs.getString("bookname"));
	        	  book.setAothor(rs.getString("author"));
	        	  book.setEleprice(rs.getString("eleprice"));
	        	  book.setEntprice(rs.getString("entprice"));
	        	  book.setImage_path(rs.getString("image_path"));
	        	  book.setStock(rs.getString("stock"));
	        	  book.setList_time(rs.getString("list_time"));
	        	  list.add(book);
	        	  
	          }
	          
	          
	          JSONArray jo=new JSONArray();
	          jo.addAll(list);
	          System.out.println(jo.toString());
	          
	          out.write(jo.toString());
	         
	          
			}
			catch(Exception r){r.printStackTrace();}
			finally{
			out.flush();
			out.close();
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
