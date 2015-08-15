package com.dep.javabean;

import java.sql.Date;


public class Bookinfo {

	private String bookname;
	private String aothor;
	private String eleprice;
	private String entprice;
	private String stock;
	private String list_time;
	private String image_path;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAothor() {
		return aothor;
	}
	public void setAothor(String aothor) {
		this.aothor = aothor;
	}
	public String getEleprice() {
		return eleprice;
	}
	public void setEleprice(String eleprice) {
		this.eleprice = eleprice;
	}
	public String getEntprice() {
		return entprice;
	}
	public void setEntprice(String entprice) {
		this.entprice = entprice;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getList_time() {
		return list_time;
	}
	public void setList_time(String list_time) {
		this.list_time = list_time;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public Bookinfo(String bookname, String aothor, String eleprice,
			String entprice, String stock, String list_time, String image_path) {
		super();
		this.bookname = bookname;
		this.aothor = aothor;
		this.eleprice = eleprice;
		this.entprice = entprice;
		this.stock = stock;
		this.list_time = list_time;
		this.image_path = image_path;
	}
	public Bookinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
