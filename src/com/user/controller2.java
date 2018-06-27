package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro_price.jdbc;
import com.user.service.UserServiceImpl;

@WebServlet("/controller2") 
public class controller2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");  
		ServletContext se =getServletContext();
		 for(int x=1;x<=10;x++) {                   
	    	 String temp="pro";                                                          
	             temp+=x;                                                                                                                         
	         	String name=(String) se.getAttribute(temp);
	    	if(name!=null) 
	       {                                              
	    		int price =jdbc.getProPrice(name);
	    		se.setAttribute(temp,name);    		                     
	    		out.println(price+"    "+name);
	    	}//if
	     }//for   
	System.out.println("<body><a href=\"Headerkart.jsp\"></body>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
