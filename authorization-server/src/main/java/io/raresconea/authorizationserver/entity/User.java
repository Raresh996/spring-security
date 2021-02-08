package io.raresconea.authorizationserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

	@Column(nullable = false) private String username;

	@Column(nullable = false) private String password;

	@Column(nullable = false, name = "first_name") private String firstName;

	@Column(nullable = false, name = "last_name") private String lastName;

	@ManyToOne @JoinColumn(referencedColumnName = "id", name = "role_id") private Role role;
}
