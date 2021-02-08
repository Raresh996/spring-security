package io.raresconea.authorizationserver.service.impl;

import io.raresconea.authorizationserver.entity.UserDetailsImpl;
import io.raresconea.authorizationserver.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserDetailsImpl(this.userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User with username {} not found", username))));
	}
}
