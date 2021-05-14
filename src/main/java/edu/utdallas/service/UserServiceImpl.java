package edu.utdallas.service;

import edu.utdallas.dto.UserRole;
import edu.utdallas.entity.Role;
import edu.utdallas.entity.User;
import edu.utdallas.repository.RoleRepository;
import edu.utdallas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by asdha on 5/28/2017.
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final RoleRepository roleRepository;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void save(edu.utdallas.dto.User user) {
		User userEntity = new User();
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setUsername(user.getUsername());
		HashSet<Role> roles = new HashSet<>();

		if(user.getUserRole() == UserRole.ADMIN){
			roles.add(roleRepository.getRole(UserRole.ADMIN.toString()));
		}else if(user.getUserRole() == UserRole.TEACHER){
			roles.add(roleRepository.getRole(UserRole.TEACHER.toString()));
		}else{
			roles.add(roleRepository.getRole(UserRole.STUDENT.toString()));
		}
		userEntity.setRoles(roles);
		this.userRepository.save(userEntity);
	}
}
