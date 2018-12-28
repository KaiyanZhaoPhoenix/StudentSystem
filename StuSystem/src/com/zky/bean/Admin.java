package com.zky.bean;
import java.io.Serializable;
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String adminname;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
