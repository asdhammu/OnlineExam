package edu.UTDallas.service;

import org.hibernate.SessionFactory;

import edu.UTDallas.entity.User;

/**
 * Created by asdha on 5/28/2017.
 */
public class UserServiceImpl implements UserService {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User findByUsername(String username){
		
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}
}
