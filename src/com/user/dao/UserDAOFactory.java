package com.user.dao;

public class UserDAOFactory {
	
	public static UserDAO getInstance() {
		System.out.println("jhggh");
		return new UserDAOImpl();
	
	}
	
}
