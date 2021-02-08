package io.raresconea.authorizationserver.converter;

import io.raresconea.authorizationserver.dto.RoleDto;
import io.raresconea.authorizationserver.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class RoleConverter {

	public RoleDto convertToDto(Role entity) {
		Assert.notNull(entity, "Role entity can not be null");

		RoleDto result = new RoleDto();
		result.setId(entity.getId());
		result.setName(entity.getName());

		return result;
	}

	public Role convertToEntity(RoleDto dto) {
		Assert.notNull(dto, "Role dto can not be null");

		Role result = new Role();
		result.setId(dto.getId());
		result.setName(dto.getName());

		return result;
	}

}
