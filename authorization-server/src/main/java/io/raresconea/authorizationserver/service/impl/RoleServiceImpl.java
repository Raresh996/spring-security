package io.raresconea.authorizationserver.service.impl;

import io.raresconea.authorizationserver.entity.Role;
import io.raresconea.authorizationserver.exception.RoleNotFoundException;
import io.raresconea.authorizationserver.repository.RoleRepository;
import io.raresconea.authorizationserver.service.RoleService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role save(Role role) {
		Assert.notNull(role, "Role can not be null");

		return roleRepository.save(role);
	}

	@Override
	public Role findByName(String name) {
		Assert.notNull(name, "Name can not be null");

		return roleRepository.findByNameIgnoreCase(name)
				.orElseThrow(() -> new RoleNotFoundException(String.format("Role with name {} not found", name)));
	}
}
