package io.raresconea.resourceserver.service;

import io.raresconea.resourceserver.entity.Stock;

import java.util.List;

public interface StockService {
	Stock findById(Integer id);

	Stock findByName(String name);

	Stock save(Stock stock);

	List<Stock> findAll();

	Stock update(Integer id, Stock stock);
}
