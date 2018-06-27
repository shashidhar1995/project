package com.user;

import java.util.List;


public class UserParent {
	private int id;
	private String name;
	
	private List<Product> plist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}                                       
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> list) {
		this.plist = list;
	}
	
	
}
