package io.raresconea.resourceserver.converter;

import io.raresconea.resourceserver.dto.PortofolioDto;
import io.raresconea.resourceserver.entity.Portofolio;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.stream.Collectors;

@Component
public class PortofolioConverter {
	private final PortofolioToStockConverter portofolioToStockConverter;

	public PortofolioConverter(PortofolioToStockConverter portofolioToStockConverter) {
		this.portofolioToStockConverter = portofolioToStockConverter;
	}

	public PortofolioDto convertToDto(Portofolio portofolio) {
		Assert.notNull(portofolio, "Portofolio can not be null");

		PortofolioDto result = new PortofolioDto();
		result.setId(portofolio.getId());
		result.setStocks(portofolio.getStocks().stream()
				.map(portofolioToStockConverter::convertToDto).collect(
				Collectors.toList()));

		return result;
	}
}
