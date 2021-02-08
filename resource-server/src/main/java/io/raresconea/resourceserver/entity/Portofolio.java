package io.raresconea.resourceserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Portofolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String username;

	@OneToMany(mappedBy = "portofolio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PortofolioToStock> stocks = new ArrayList<>();
}
