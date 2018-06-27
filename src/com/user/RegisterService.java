package com.user;

import org.hibernate.Query; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.order.User;
         
public class RegisterService {
	public static boolean register(User user){
	
		Session session = null;
	//	if(isUserExists(user)) return false;
		  Configuration cfg=null;          
		  Transaction tx = null;                                                                
		  cfg=new Configuration();
		  try {                  
			session=HibernateUtil.getSession();;
			tx = session.beginTransaction();         
	     session.saveOrUpdate(user);                                                                   
		tx.commit();
		} catch (Exception e) {                             
		if (tx != null) {                                            
		tx.rollback();
		}            
		e.printStackTrace();
		} finally {     
		session.close();
		}
		return true;
		}
		
	public boolean isUserExists(User user){
		
		Session session = HibernateUtil.getSession();
		
	boolean result = false;
	Transaction tx = null;             
		try {
		tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from User where userId='"+user.getId()+"'");
		User u = (User)query.uniqueResult();
		tx.commit();             
	if(u!=null) 
		result = true;
	
		}catch(Exception ex){
		if(tx!=null){
			tx.rollback();
		}
		}finally{
		session.close();  
		}
		return result;
		}
}
