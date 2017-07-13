package edu.UTDallas.service;

import edu.UTDallas.entity.User;

public interface UserService {
	public User findByUsername(String username);
	public void save(User user);
}
