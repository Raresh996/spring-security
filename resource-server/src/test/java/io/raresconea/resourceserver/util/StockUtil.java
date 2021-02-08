package io.raresconea.resourceserver.util;

import io.raresconea.resourceserver.dto.StockDto;
import io.raresconea.resourceserver.entity.Stock;

public class StockUtil {
	public static Stock createEntity(Integer id, String name, Double price, Double dividend) {
		Stock stock = new Stock();

		stock.setId(id);
		stock.setName(name);
		stock.setPrice(price);
		stock.setDividend(dividend);

		return stock;
	}

	public static StockDto createDto(Integer id, String name, Double price, Double dividend) {
		StockDto stock = new StockDto();

		stock.setId(id);
		stock.setName(name);
		stock.setPrice(price);
		stock.setDividend(dividend);

		return stock;
	}
}
