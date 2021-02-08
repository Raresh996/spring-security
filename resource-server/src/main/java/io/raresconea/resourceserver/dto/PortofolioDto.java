package io.raresconea.resourceserver.dto;

import lombok.Data;

import java.util.List;

@Data
public class PortofolioDto {
	private Integer id;
	private List<PortofolioToStockDto> stocks;
}
