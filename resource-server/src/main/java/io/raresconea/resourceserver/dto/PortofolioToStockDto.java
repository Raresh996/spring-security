package io.raresconea.resourceserver.dto;

import lombok.Data;

@Data
public class PortofolioToStockDto {
	private Integer id;
	private Integer portofolioId;
	private StockDto stock;
	private Integer numberOf;
}
