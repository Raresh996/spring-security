package io.raresconea.resourceserver.dto;

import lombok.Data;

@Data
public class StockDto extends BaseEntityDto {
	private Double price;
	private Double dividend;
}
