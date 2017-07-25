package edu.UTDallas.dao.repository;

import edu.UTDallas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by asdha on 5/27/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
