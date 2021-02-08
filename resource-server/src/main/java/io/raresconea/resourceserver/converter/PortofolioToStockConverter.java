package io.raresconea.resourceserver.converter;

import io.raresconea.resourceserver.dto.PortofolioToStockDto;
import io.raresconea.resourceserver.entity.PortofolioToStock;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PortofolioToStockConverter {
	private final StockConverter stockConverter;

	public PortofolioToStockConverter(StockConverter stockConverter) {
		this.stockConverter = stockConverter;
	}

	public PortofolioToStock convertToEntity(PortofolioToStockDto dto) {
		Assert.notNull(dto, "PortofolioToStock dto can not be null");

		PortofolioToStock result = new PortofolioToStock();
		result.setId(dto.getId());
		result.setStock(this.stockConverter.convertToEntity(dto.getStock()));
		result.setNumberOf(dto.getNumberOf());

		return result;
	}

	public PortofolioToStockDto convertToDto(PortofolioToStock entity) {
		Assert.notNull(entity, "PortofolioToStock entity can not be null");

		PortofolioToStockDto result = new PortofolioToStockDto();
		result.setId(entity.getId());
		result.setPortofolioId(entity.getPortofolio().getId());
		result.setNumberOf(entity.getNumberOf());
		result.setStock(this.stockConverter.convertToDto(entity.getStock()));

		return result;
	}
}
