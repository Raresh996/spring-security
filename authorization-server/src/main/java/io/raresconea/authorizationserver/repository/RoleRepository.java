package io.raresconea.authorizationserver.repository;

import io.raresconea.authorizationserver.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByNameIgnoreCase(String name);
}
