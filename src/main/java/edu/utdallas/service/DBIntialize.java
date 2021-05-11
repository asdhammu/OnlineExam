package edu.utdallas.service;

import edu.utdallas.dto.UserRole;
import edu.utdallas.entity.Role;
import edu.utdallas.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Service
public class DBIntialize {
    private final static Logger logger = Logger.getAnonymousLogger();
    private final RoleRepository repository;

    public DBIntialize(RoleRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    void init() {
        for (var role : UserRole.values()) {
            repository.saveAndFlush(new Role(role.name()));
        }
        logger.info("Roles table initialized");
    }
}
