package io.raresconea.authorizationserver.commandLineRunner;

import io.raresconea.authorizationserver.entity.Role;
import io.raresconea.authorizationserver.entity.User;
import io.raresconea.authorizationserver.repository.UserRepository;
import io.raresconea.authorizationserver.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	private final UserRepository userRepository;
	private final RoleService roleService;

	public CommandLineAppStartupRunner(UserRepository userRepository, RoleService roleService) {
		this.userRepository = userRepository;
		this.roleService = roleService;
	}

	@Override
	public void run(String... args) throws Exception {
		Role roleAdmin = roleService.save(new Role(1, "ADMIN"));

		userRepository.save(new User(1, "admin", "admin", "firstNameAdmin", "lastNameAdmin", roleAdmin));
	}

}
