package io.raresconea.resourceserver.service;

import io.raresconea.resourceserver.entity.Stock;
import io.raresconea.resourceserver.exception.StockNotFoundException;
import io.raresconea.resourceserver.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockService {
	private StockRepository stockRepository;

	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	public Stock findById(Integer id) {
		Assert.notNull(id, "Stock id can not be null");

		return this.stockRepository.findById(id)
				.orElseThrow(() -> new StockNotFoundException(String.format("Stock with id {} not found", id)));
	}

	public Stock findByName(String name) {
		Assert.notNull(name, "Name can not be null");

		return this.stockRepository.findByNameIgnoreCase(name)
				.orElseThrow(() -> new StockNotFoundException(String.format("Stock with name {} not found", name)));
	}

	@Transactional
	public Stock save(Stock stock) {
		Assert.notNull(stock, "Stock can not be null");

		return this.stockRepository.save(stock);
	}

	public List<Stock> findAll() {
		return this.stockRepository.findAll();
	}

	public Stock update(Integer id, Stock stock) {
		Assert.notNull(id, "Stock id can not be null");
		Assert.notNull(stock, "Stock can not be null");

		return stockRepository.save(stock);
	}
}
