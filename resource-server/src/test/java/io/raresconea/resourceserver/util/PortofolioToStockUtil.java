package io.raresconea.resourceserver.util;

import io.raresconea.resourceserver.dto.PortofolioToStockDto;
import io.raresconea.resourceserver.dto.StockDto;
import io.raresconea.resourceserver.entity.Portofolio;
import io.raresconea.resourceserver.entity.PortofolioToStock;
import io.raresconea.resourceserver.entity.Stock;

public class PortofolioToStockUtil {

	public static PortofolioToStock createEntity(Integer id,
			Portofolio portofolio,
			Stock stock,
			Integer numberOf) {
		PortofolioToStock entity = new PortofolioToStock();

		entity.setId(id);
		entity.setPortofolio(portofolio);
		entity.setStock(stock);
		entity.setNumberOf(numberOf);

		return entity;
	}

	public static PortofolioToStockDto createDto(Integer id,
			StockDto stock,
			Integer numberOf) {
		PortofolioToStockDto dto = new PortofolioToStockDto();

		dto.setId(id);
		dto.setStock(stock);
		dto.setNumberOf(numberOf);

		return dto;
	}
}
