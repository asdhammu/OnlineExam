package edu.utdallas.service;

import edu.utdallas.dto.UserRole;
import edu.utdallas.entity.Role;
import edu.utdallas.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Service
public class DBInitializer {
    private final static Logger logger = Logger.getAnonymousLogger();
    private final RoleRepository repository;

    public DBInitializer(RoleRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    void init() {
        logger.warning("****************************************************");
        for (var userRole : UserRole.values()) {
            var role = new Role(userRole.name());
            repository.saveAndFlush(role);
            logger.warning("Role " + role.toString() + " is initialized");
        }
        logger.info("Roles table initialized");
    }
}
