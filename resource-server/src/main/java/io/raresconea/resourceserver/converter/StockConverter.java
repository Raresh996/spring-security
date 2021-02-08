package io.raresconea.resourceserver.converter;

import io.raresconea.resourceserver.dto.StockDto;
import io.raresconea.resourceserver.entity.Stock;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class StockConverter {
	public StockDto convertToDto(Stock entity) {
		Assert.notNull(entity, "Stock entity can not be null");

		StockDto result = new StockDto();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDividend(entity.getDividend());
		result.setPrice(entity.getPrice());

		return result;
	}

	public Stock convertToEntity(StockDto dto) {
		Assert.notNull(dto, "Stock dto can not be null");

		Stock result = new Stock();
		result.setId(dto.getId());
		result.setName(dto.getName());
		result.setDividend(dto.getDividend());
		result.setPrice(dto.getPrice());

		return result;
	}
}
