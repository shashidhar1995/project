 package com.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.user.Product;
import com.user.UserParent;
import com.user.dao.UserDAO;
import com.user.dao.UserDAOFactory;
import com.user.dto.ProductDTO;
import com.user.dto.UserDTO;
              
public class UserServiceImpl implements UserService {    
	private static SessionFactory sessionFactory;
	public  int saveData( UserParent udto,Map<String, Integer> hm,int temp,String name) {            
		UserParent user=new UserParent();                
		                                                                                                                                 
		Product p=new Product(); 
        Session ses=null;    
       
		Transaction tx=null;
		boolean flag=false;                                        
			  Configuration cfg=null;              
			  cfg=new Configuration();                                         
			                  
			  user.setName(name);           
		
		List<Product> list=new ArrayList<Product>();
		
		int x=0;                             
		int teemp=1;
           for(Map.Entry<String,Integer> h:hm.entrySet()) {
	         Product pro=new Product();                          
	            	 pro.setProdName(h.getKey());
	            	 pro.setProdPrice(h.getValue());   
	                // prodto1.setProdId(proid);  
	                 pro.setOrderedDate(new Date());
 	            	 list.add(pro);
 	            	 pro=null;
 	            	 System.out.println("inserting "+teemp+"st product");
 	            	 teemp++;
	            	 }                                       
		user.setPlist(list);
		try {
			 cfg.configure("com/user/hibernate.configuration.xml");    
			  sessionFactory=cfg.buildSessionFactory();
			 ses=sessionFactory.openSession();
			tx=ses.beginTransaction();
			x=(int) ses.save(user);
			flag=true;
			tx.commit();
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}                 
		return x;
	}      

}
