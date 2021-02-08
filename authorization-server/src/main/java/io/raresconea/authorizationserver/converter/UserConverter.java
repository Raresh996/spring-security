package io.raresconea.authorizationserver.converter;

import io.raresconea.authorizationserver.dto.UserDto;
import io.raresconea.authorizationserver.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserConverter {
	private final RoleConverter roleConverter;

	public UserConverter(RoleConverter roleConverter) {
		this.roleConverter = roleConverter;
	}

	public UserDto convertToDto(User user) {
		Assert.notNull(user, "User entity can not be null");

		UserDto result = new UserDto();
		result.setId(user.getId());
		result.setUsername(user.getUsername());
		result.setFirstName(user.getFirstName());
		result.setLastName(user.getLastName());
		result.setRole(roleConverter.convertToDto(user.getRole()));

		return result;
	}

	public User convertToEntity(UserDto dto) {
		Assert.notNull(dto, "User dto can not be null");

		User result = new User();
		result.setId(dto.getId());
		result.setUsername(dto.getUsername());
		result.setPassword(dto.getPassword());
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());

		return result;
	}
}
