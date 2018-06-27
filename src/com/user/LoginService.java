 package com.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.order.User;

public class LoginService {      
	/*static Session session;
	  static {
		  SessionFactory sessionFactory;
		  Configuration cfg=null;              
		  cfg=new Configuration();       
		                 
		  try {
			  cfg.configure("com/user/hibernate.cfg.xml");
			  sessionFactory=cfg.buildSessionFactory();
			  session=sessionFactory.openSession();
		  }catch(HibernateException he) {     
			  he.printStackTrace();
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
*/
    public boolean authenticateUser(String email, String password) {
        User user = getUserByUserId(email);         
        if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password)){
            return true;
        }else{          
            return false;                
        }               
    }                        
                         
    public User getUserByUserId(String email) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;       
        User user = null;           
        try {
            tx = session.getTransaction();             
            tx.begin();
            Query query = session.createQuery("from User where email='"+email+"'");
            user = (User)query.uniqueResult();
           // user=(User) query.list();
            tx.commit();             
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
                 
    public List<User> getListOfUsers(){
        List<User> list = new ArrayList<User>();
        Session session = HibernateUtil.getSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from User").list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {                      
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
