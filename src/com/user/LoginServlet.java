package com.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.User;
@WebServlet("/LoginServlet")   
public class LoginServlet extends HttpServlet {
	  public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	                       
	     String userId = request.getParameter("email");      
	     String password = request.getParameter("password");                
	     ServletContext sess=getServletContext();
	     sess.setAttribute("email",userId);                           
	     LoginService loginService = new LoginService();
	     boolean result = loginService.authenticateUser(userId, password);
	     User user = loginService.getUserByUserId(userId);
	     if(result == true){
	         request.getSession().setAttribute("user", user);      
	         response.sendRedirect("home.jsp");
	     }
	     else{                           
	         response.sendRedirect("error.jsp");   
	     }
	
	  }
}
                 