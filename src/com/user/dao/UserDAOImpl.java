package com.user.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.user.HibernateUtil;
import com.user.Product;
import com.user.dto.UserDTO;
                                                           
public class UserDAOImpl implements UserDAO{
	 private static SessionFactory sessionFactory; 
	public int saveData(UserDTO user) {
		int id=0;                           
		Session ses=null;
		
		Transaction tx=null;
		boolean flag=false;                  
			  Configuration cfg=null;              
			  cfg=new Configuration();                                
			  try {
				  cfg.configure("com/user/hibernate.configuration.xml");    
				  sessionFactory=cfg.buildSessionFactory();
				 ses=sessionFactory.openSession();
		     	  }catch(HibernateException he) {     
				  he.printStackTrace();
			  }catch(Exception e) {
				  e.printStackTrace();
			  }

		//Product prod=null;
		try {
			tx=ses.beginTransaction();
			id=(Integer)ses.save(user);
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				tx.commit();
			}else {
				tx.rollback();
			}
		}
		return id;
	}
	
}
