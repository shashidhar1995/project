package com.user;  
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.order.User;
                                                                                    
@WebServlet("/RegisterServlet")                                                                        
public class RegisterServlet extends HttpServlet {
	                        
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {     
	 response.setContentType("text/html");                         
     PrintWriter out = response.getWriter();     
     String name = request.getParameter("name");                             
     String lastName = request.getParameter("lastName");
     long phone =Long.parseLong(request.getParameter("phone"));     
     String email = request.getParameter("email");                            
     String password = request.getParameter("password");
     String country = request.getParameter("country");
  
    User user = new User(name,lastName,phone, email, password,country);
                                                
     try {           
    	 Session se =HibernateUtil.getSession();
    	 Transaction tx=se.beginTransaction();
    	 se.save(user);
    	 tx.commit();
         RegisterService registerService = new RegisterService();
        boolean result = registerService.register(user);      
         out.println("<html>");          
         out.println("<head>");      
         out.println("<title>Registration Successful</title>");    
         out.println("</head>");            
         out.println("<body>");           
         out.println("<center>");
         if(result){               
             out.println("<h1>Thanks for Registering with us :</h1>");
             out.println("To login with new UserId and Password<a href=index.jsp>Click here</a>");
         }else{
             out.println("<h1>Registration Failed</h1>");
             out.println("To try again<a href=reister.jsp>Click here</a>");
         }  
         out.println("</center>");
         out.println("</body>");
         out.println("</html>");
     } finally {                              
         out.close();
     }
}

	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {     
doGet(request,response);
}}
