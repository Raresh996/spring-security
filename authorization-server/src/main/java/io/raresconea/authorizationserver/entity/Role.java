package io.raresconea.authorizationserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

	@Column(nullable = false) private String name;
}
