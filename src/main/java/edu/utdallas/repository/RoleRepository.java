package edu.utdallas.repository;

import edu.utdallas.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by asdha on 5/27/2017.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select t from Role t where name =:name")
    Role getRole(@Param("name") String name);
}
