package io.raresconea.authorizationserver.service;

import io.raresconea.authorizationserver.entity.MyClientDetails;
import io.raresconea.authorizationserver.exception.ClientNotFoundException;
import io.raresconea.authorizationserver.repository.ClientRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class MyClientDetailsService implements ClientDetailsService {
	private final ClientRepository clientRepository;

	public MyClientDetailsService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		return new MyClientDetails(clientRepository.findByClientId(clientId)
				.orElseThrow(() -> new ClientNotFoundException(String.format("Client with id %s not found", clientId))));
	}
}
