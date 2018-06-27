package com.user;

import java.io.IOException;  
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro_price.jdbc;
import com.user.service.UserServiceImpl;
                            
@WebServlet("/controller")                                  
public class controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		                
		ServletContext ses=getServletContext();
		                        PrintWriter pw= response.getWriter();             
		                        response.setContentType("text/html");   
	   Map<String,Integer> hm=new HashMap();       
	 
	    ServletContext sess=getServletContext();    
	   String email= (String)sess.getAttribute("email");
	    UserParent udto=new UserParent();
	         
	    int tem=0;
     for(int x=1;x<=10;x++) { 
    	 String temp="pro";                                                             
             temp+=x;                                                                                 
    	String name=request.getParameter(temp);         
    	if(name!=null)                   
       {                            
    		int price =jdbc.getProPrice(name);
    		//ses.setAttribute(temp,name);
    		hm.put(name, price);                               
    	tem++;
    	}//if
    	temp=null;
     }//for 
             
    String valu="";
    valu+=tem;                       
     sess.setAttribute("value",valu);   
     UserServiceImpl us=new UserServiceImpl();         
   int value= us.saveData(udto, hm,tem,email);             
     hm.entrySet().stream().forEach(e->{pw.println("<html><body>name  "+e.getKey()+"  price   "+e.getValue()+" <br></body></html>"
          		);});
     if(value==0) {System.out.println("not inserted");}
     else {pw.println("insertedSystem.out.println(\"<body><a href=Headerkart.jsp></body>\");");}  
     RequestDispatcher sd=request.getRequestDispatcher("Headerkart.jsp");
     sd.include(request,response);     
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {                         
	
		doGet(request, response);
	}                 
                                      
}
                      