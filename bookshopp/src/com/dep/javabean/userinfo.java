package com.dep.javabean;

public class userinfo {

	private String username;
	private String userpasswd;
	private int user_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpasswd() {
		return userpasswd;
	}
	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}
	public userinfo(String username, String userpasswd,int user_id) {
		super();
		this.username = username;
		this.userpasswd = userpasswd;
		this.user_id=user_id;
	}
	public userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
