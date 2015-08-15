package com.dep.info;
public class bookinfo_car {

	private String bookname;
	private String author;
	private String imgpath;
	private String entbook;
	private String elebook;
	private String eleprice;

	private String entprice;
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
	
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getEntbook() {
		return entbook;
	}
	public void setEntbook(String entbook) {
		this.entbook = entbook;
	}
	public String getElebook() {
		return elebook;
	}
	public void setElebook(String elebook) {
		this.elebook = elebook;
	}
	public String getEntprice() {
		return entprice;
	}
	public void setEntprice(String entprice) {
		this.entprice = entprice;
	}
	public String getEleprice() {
		return eleprice;
	}
	public void setEleprice(String eleprice) {
		this.eleprice = eleprice;
	}
	public bookinfo_car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bookinfo_car(String bookname, String author, String imgpath, String entbook,
			String elebook, String entprice, String eleprice) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.imgpath = imgpath;
		this.entbook = entbook;
		this.elebook = elebook;
		this.entprice = entprice;
		this.eleprice = eleprice;
	}
	
	
}
