package com.user;                   
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.order.User;
             
public class HibernateUtil {
	  private static SessionFactory sessionFactory;                            
	  private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	  static {                                             
		  Configuration cfg=null;                 
		  cfg=new Configuration();                                
		  try {                                             
			  cfg.configure("com/user/hibernate.cfg.xml");
			  sessionFactory=cfg.buildSessionFactory();
	
		  }catch(HibernateException he) {     
			  he.printStackTrace();
		  }catch(Exception e) {       
			  e.printStackTrace();
		  }    
	  }
		 public static Session getSession() {
			 Session ses=null;
			 if(ses==null) {            
				 ses=sessionFactory.openSession();
			 threadLocal.set(ses);
			 }else {
				ses=threadLocal.get();
			 }
			 return ses;    
		 }
		 public static void closeSession() {
			 Session ses=null;
		ses=threadLocal.get();
			 if(ses!=null) {
				 ses.close();
			threadLocal.remove();
			 }
		 }
	 
		 public static void closeSessionFactory() {

			 if(sessionFactory!=null) {
				 sessionFactory.close();
			 }
		 } 
		 }
    
