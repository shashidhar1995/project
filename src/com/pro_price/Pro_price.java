package com.pro_price;

import javax.persistence.Entity;
import javax.persistence.Table;
    
public class Pro_price {          
	
	
	private String pro_name;
	private int pro_price;

	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;          
	}           
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {                        
		this.pro_price = pro_price;
	}
	
	
}
