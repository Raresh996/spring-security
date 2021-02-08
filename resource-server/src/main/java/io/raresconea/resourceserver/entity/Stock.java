package io.raresconea.resourceserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Stock extends BaseEntity {
	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private Double dividend;
}
