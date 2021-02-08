package io.raresconea.resourceserver.service;

import io.raresconea.resourceserver.entity.PortofolioToStock;
import io.raresconea.resourceserver.repository.PortofolioToStockRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PortofolioToStockService {
	private final PortofolioToStockRepository portofolioToStockRepository;

	public PortofolioToStockService(PortofolioToStockRepository portofolioToStockRepository) {
		this.portofolioToStockRepository = portofolioToStockRepository;
	}

	public PortofolioToStock save(PortofolioToStock portofolioToStock) {
		Assert.notNull(portofolioToStock, "PortofolioToStock can not be null");

		return portofolioToStockRepository.save(portofolioToStock);
	}
}
