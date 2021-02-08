package io.raresconea.authorizationserver.service;

import io.raresconea.authorizationserver.entity.Role;
import io.raresconea.authorizationserver.exception.RoleNotFoundException;
import io.raresconea.authorizationserver.repository.RoleRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class RoleService {
	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public Role save(Role role) {
		Assert.notNull(role, "Role can not be null");

		return roleRepository.save(role);
	}

	public Role findByName(String name) {
		Assert.notNull(name, "Name can not be null");

		return roleRepository.findByNameIgnoreCase(name)
				.orElseThrow(() -> new RoleNotFoundException(String.format("Role with name %s not found", name)));
	}
}
