package io.raresconea.authorizationserver.commandLineRunner;

import io.raresconea.authorizationserver.entity.Client;
import io.raresconea.authorizationserver.entity.Role;
import io.raresconea.authorizationserver.entity.User;
import io.raresconea.authorizationserver.repository.ClientRepository;
import io.raresconea.authorizationserver.repository.RoleRepository;
import io.raresconea.authorizationserver.repository.UserRepository;
import io.raresconea.authorizationserver.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final ClientRepository clientRepository;

	public CommandLineAppStartupRunner(UserRepository userRepository, RoleRepository roleRepository,
			ClientRepository clientRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.clientRepository = clientRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Role roleAdmin = roleRepository.save(new Role(1, "ADMIN"));

		userRepository.save(new User(1, "admin", "admin", "firstNameAdmin", "lastNameAdmin", roleAdmin));

		Client client = new Client();
		client.setClientId("client");
		client.setClientSecret("secret");
		client.setAuthorizedGrantTypes("password,authorization_code,refresh_token,client_credentials,implicit");
		client.setScope("read,write");

		clientRepository.save(client);
	}
}
