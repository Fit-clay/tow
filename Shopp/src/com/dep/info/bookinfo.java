package com.dep.info;

public class bookinfo {

	private String bookname;
	private String author;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public bookinfo(String bookname, String author, String eleprice,
			String entprice, String stock, String list_time, String image_path) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.eleprice = eleprice;
		this.entprice = entprice;
		this.stock = stock;
		this.list_time = list_time;
		this.image_path = image_path;
	}
	public bookinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
