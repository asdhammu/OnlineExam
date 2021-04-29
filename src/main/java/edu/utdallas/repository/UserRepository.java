package edu.utdallas.repository;

import edu.utdallas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by asdha on 5/27/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
