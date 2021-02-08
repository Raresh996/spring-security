package io.raresconea.resourceserver.service.impl;

import io.raresconea.resourceserver.entity.Stock;
import io.raresconea.resourceserver.exception.StockNotFoundException;
import io.raresconea.resourceserver.repository.StockRepository;
import io.raresconea.resourceserver.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
	private StockRepository stockRepository;

	public StockServiceImpl(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	@Override
	public Stock findById(Integer id) {
		Assert.notNull(id, "Stock id can not be null");

		return this.stockRepository.findById(id)
				.orElseThrow(() -> new StockNotFoundException(String.format("Stock with id {} not found", id)));
	}

	@Override
	public Stock findByName(String name) {
		Assert.notNull(name, "Name can not be null");

		return this.stockRepository.findByNameIgnoreCase(name)
				.orElseThrow(() -> new StockNotFoundException(String.format("Stock with name {} not found", name)));
	}

	@Override
	@Transactional
	public Stock save(Stock stock) {
		Assert.notNull(stock, "Stock can not be null");

		return this.stockRepository.save(stock);
	}

	@Override
	public List<Stock> findAll() {
		return this.stockRepository.findAll();
	}

	@Override
	public Stock update(Integer id, Stock stock) {
		Assert.notNull(id, "Stock id can not be null");
		Assert.notNull(stock, "Stock can not be null");

		return stockRepository.save(stock);
	}
}
