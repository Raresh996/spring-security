package io.raresconea.resourceserver.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String name;
}
