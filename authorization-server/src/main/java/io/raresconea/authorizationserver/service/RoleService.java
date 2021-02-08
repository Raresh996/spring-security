package io.raresconea.authorizationserver.service;

import io.raresconea.authorizationserver.entity.Role;

public interface RoleService {
	Role save(Role role);

	Role findByName(String role_user);
}
