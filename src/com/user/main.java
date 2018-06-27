package com.user;

import java.util.HashMap;
import java.util.Map;

import com.order.User;
import com.pro_price.jdbc;

public class main {

	public static void main(String[] args) {	                           
		   Map<String,Integer> hm=new HashMap();
	    
	          hm.entrySet().stream().forEach(e->{
	        	  System.out.println("name"+e.getKey()+" price"+e.getValue());
	        	  }   
	             );       
	          HibernateUtil hu=new HibernateUtil();
	   
	          User u1=new User();
	          System.out.println(u1.getLastName());
	        }
	}
   