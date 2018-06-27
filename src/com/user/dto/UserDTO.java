package com.user.dto;


import java.io.Serializable;
import java.util.List;

import com.user.Product;

public class UserDTO implements Serializable{
	
	
	private int id;                                     
	private String name;
	private List<ProductDTO> plist;
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
	public List<ProductDTO> getPlist() {
		return plist;
	}
	public void setPlist(List<ProductDTO> plist) {
		this.plist = plist;
	}

}
