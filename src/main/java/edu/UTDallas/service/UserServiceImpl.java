package edu.UTDallas.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.UTDallas.dao.UserDao;
import edu.UTDallas.dao.repository.UserRepository;
import edu.UTDallas.entity.User;

/**
 * Created by asdha on 5/28/2017.
 */
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findByUsername(String username) {

		return this.userRepository.findByUsername(username);
	}

	@Override
	public void save(User user) {
		this.userDao.save(user);
	}
}
