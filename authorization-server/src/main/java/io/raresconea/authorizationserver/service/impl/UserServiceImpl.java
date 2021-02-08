package io.raresconea.authorizationserver.service.impl;

import io.raresconea.authorizationserver.entity.User;
import io.raresconea.authorizationserver.repository.UserRepository;
import io.raresconea.authorizationserver.service.RoleService;
import io.raresconea.authorizationserver.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final RoleService roleService;

	public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
		this.userRepository = userRepository;
		this.roleService = roleService;
	}

	@Override
	public User save(User user, String role) {
		Assert.notNull(user, "User can not be null");

		user.setRole(roleService.findByName(role));

		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		Assert.notNull(username, "Username can not be null");

		return userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User with username {} not found", username)));
	}
}
