package io.raresconea.authorizationserver.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MyClientDetails implements ClientDetails {
	private final Client client;
	private ObjectMapper mapper;

	public MyClientDetails(Client client) {
		this.client = client;
	}

	@Override
	public String getClientId() {
		return client.getClientId();
	}

	@Override
	public Set<String> getResourceIds() {
		return StringUtils.commaDelimitedListToSet(client.getResourceIds());
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return client.getClientSecret();
	}

	@Override
	public boolean isScoped() {
		return getScope().size() > 0;
	}

	@Override
	public Set<String> getScope() {
		return StringUtils.commaDelimitedListToSet(client.getScope());
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return StringUtils.commaDelimitedListToSet(client.getAuthorizedGrantTypes());
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return StringUtils.commaDelimitedListToSet(client.getRegisteredRedirectUri());
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return StringUtils.commaDelimitedListToSet(client.getAuthorities()).stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return client.getAccessTokenValiditySeconds();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return client.getRefreshTokenValiditySeconds();
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return getAutoApproveScope().contains(scope);
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		try {
			return mapper.readValue(client.getAdditionalInformation(), Map.class);
		} catch (JsonProcessingException e) {
			return Collections.emptyMap();
		}
	}

	public Set<String> getAutoApproveScope() {
		return StringUtils.commaDelimitedListToSet(client.getAutoApproveScope());
	}

	@Autowired
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
}
