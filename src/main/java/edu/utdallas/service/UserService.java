package edu.utdallas.service;

import edu.utdallas.entity.User;

public interface UserService {
	
	User findByUsername(String username);
	
	void save(edu.utdallas.dto.User user);
}
