package io.raresconea.authorizationserver.rest;

import io.raresconea.authorizationserver.converter.UserConverter;
import io.raresconea.authorizationserver.dto.UserDto;
import io.raresconea.authorizationserver.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserManagementRestController {
	private static final String ROLE_USER = "user";
	private final UserService userService;
	private final UserConverter userConverter;

	public UserManagementRestController(UserService userService, UserConverter userConverter) {
		this.userService = userService;
		this.userConverter = userConverter;
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/me")
	public UserDto getAuthenticatedUserData(Authentication authentication) {
		return userConverter.convertToDto(userService.findByUsername(authentication.getName()));
	}

	@PreAuthorize("permitAll()")
	@PostMapping
	public void saveUser(@RequestBody UserDto user) {
		userService.save(userConverter.convertToEntity(user), ROLE_USER);
	}



}
