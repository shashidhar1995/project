package com.pro_price;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.order.User;
import com.user.main;

public class jdbc {
	static Pro_price pro;                               
	 public static Connection getConnection(){  

		    Connection con=null;  
		    try{                    
		        Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		    }catch(Exception e){System.out.println(e);}  
		    return con;      
		    }
	   public static int getProPrice(String pro_name){ 
		   ResultSet rs=null;
		   int temp=1;
		   int price=0;
		               
			    try{                     
			        Connection con=getConnection();  
			        PreparedStatement ps=con.prepareStatement("select pro_price from pro_price where pro_name=?"); 
			   ps.setString(1,pro_name);                                                                     
			 
			   rs=ps.executeQuery();
			 while(rs.next()) {     
			
				 price=rs.getInt(1);
				       
			   }
			    }catch(Exception e){
			    	e.printStackTrace();
			    }        
			  
			    return price;
		 }
	   public static void main(String[] args) {   
		  int price=getProPrice("chess_board");       
		   System.out.println(price+" in out");          
	}
}
