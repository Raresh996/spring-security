package io.raresconea.resourceserver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PortofolioToStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "portofolio_id", nullable = false)
	private Portofolio portofolio;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "stock_id", nullable = false)
	private Stock stock;

	@Column(nullable = false)
	private Integer numberOf;

}
