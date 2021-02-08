package io.raresconea.authorizationserver.service;

import io.raresconea.authorizationserver.entity.User;
import io.raresconea.authorizationserver.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final RoleService roleService;

	public UserService(UserRepository userRepository, RoleService roleService) {
		this.userRepository = userRepository;
		this.roleService = roleService;
	}

	public User save(User user, String role) {
		Assert.notNull(user, "User can not be null");

		user.setRole(roleService.findByName(role));

		return userRepository.save(user);
	}

	public User findByUsername(String username) {
		Assert.notNull(username, "Username can not be null");

		return userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User with username {} not found", username)));
	}
}
