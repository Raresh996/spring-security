package io.raresconea.authorizationserver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Client {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String clientId;

	private String resourceIds;

	@Column(nullable = false)
	private String clientSecret;

	private String scope = "";

	private String authorizedGrantTypes = "";

	private String registeredRedirectUri = "";

	private String authorities = "";

	private Integer accessTokenValiditySeconds;

	private Integer refreshTokenValiditySeconds;

	private String autoApproveScope = "";

	private String additionalInformation;
}



