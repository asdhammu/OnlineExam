package edu.utdallas.service;

import edu.utdallas.dto.UserRole;
import edu.utdallas.entity.Role;
import edu.utdallas.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DBIntialize {
    private final RoleRepository repository;

    public DBIntialize(RoleRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    void init() {

        for (var role : UserRole.values()) {
            repository.save(new Role(role.name()));
        }
        repository.flush();
    }
}
