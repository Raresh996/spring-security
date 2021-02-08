package io.raresconea.authorizationserver.service;

import io.raresconea.authorizationserver.entity.User;

public interface UserService {
	User save(User user, String role);

	User findByUsername(String name);
}
