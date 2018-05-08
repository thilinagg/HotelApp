package com.incubate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.incubate.models.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	//private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addUsers(User p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsers(User p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean login(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT COUNT(*) FROM users WHERE BINARY userName=:username AND BINARY passWord=sha1(:password)";
		int count = Integer.parseInt(String.valueOf((session
				.createSQLQuery(sql)
				.setParameter("username", username)
				.setParameter("password", password)
				.uniqueResult())));
		
		if (count > 0) {
			return true;
		}
		else {
			return false;
		}

	}

}
