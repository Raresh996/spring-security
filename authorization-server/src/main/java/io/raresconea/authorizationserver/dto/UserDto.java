package io.raresconea.authorizationserver.dto;

import lombok.Data;

@Data
public class UserDto {
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private RoleDto role;
}
