package io.raresconea.authorizationserver.service;

import io.raresconea.authorizationserver.entity.MyUserDetails;
import io.raresconea.authorizationserver.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	public MyUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new MyUserDetails(this.userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User with username {} not found", username))));
	}
}
